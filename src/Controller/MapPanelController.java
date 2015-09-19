package Controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.BoardMap;
import Model.Graph;

public class MapPanelController {

	private static BoardMap boardMap;

	public MapPanelController() {
		super();

		boardMap = new BoardMap();
	}

	public static int getIndexOfImage(int i, int j){
		if(boardMap.getMatrix()[i][j]>30){
			return 3;
		}
		return boardMap.getMatrix()[i][j];
	}

	public static Point getStart(){
		return boardMap.getStart();
	}

	public static void connectGraph() {
		for(int j=0;j<Constants.mapSide;j++)
			for(int i=0;i<Constants.mapSide;i++){
				{
					Graph aux = boardMap.getGraphMap().get(new Point(i,j));

					aux.setNorth(boardMap.getGraphMap().get(new Point(i,j-1)));
					aux.setSouth(boardMap.getGraphMap().get(new Point(i,j+1)));
					aux.setLest(boardMap.getGraphMap().get(new Point(i+1,j)));
					aux.setWest(boardMap.getGraphMap().get(new Point(i-1,j)));
				}
			}
	}

	public static void calcHCost() {
		for(int j=0;j<Constants.mapSide;j++)
			for(int i=0;i<Constants.mapSide;i++){
				int x = boardMap.getEnd().x - i;
				int y = boardMap.getEnd().y - j;

				int h = 0;

				if(x<0){
					x *= -1;
				}
				if(y<0){
					y *= -1;
				}

				h = x+y;
				boardMap.getGraphMap().get(new Point(i,j)).setH(h);
			}
	}

	public static void printMap(){
		Graph nextl = boardMap.getGraphMap().get(new Point(0,0));
		while(nextl != null){
			Graph previous = null;
			while(nextl != null){
				//System.out.printf("%f ",nextl.getCost());
				System.out.printf("%2f ",nextl.getH());
				previous = nextl;
				nextl = nextl.getLest();

			}
			nextl = previous;
			System.out.println();
			nextl = nextl.getSouth();
			if(nextl==null){
				break;
			}
			while(nextl != null){
				previous = nextl;
				nextl = nextl.getWest();
			}
			nextl = previous;
		}
	}

	public static ArrayList<String> aStar() {
		ArrayList<Graph> openList = new ArrayList<Graph>();
		ArrayList<Graph> closedList = new ArrayList<Graph>();
		Graph current = null;
		Graph start = boardMap.getGraphMap().get(boardMap.getStart());
		Graph end = boardMap.getGraphMap().get(boardMap.getEnd());

		current = start;
		MapPanelController.aStarAlgorithm(openList, closedList, start, end, current);

		return MapPanelController.getListOfMovements(start, end);
	}

	private static ArrayList<String> getListOfMovements(Graph start, Graph end) {
		ArrayList<String> movements = new ArrayList<String>();

		while(end != start){
			//System.out.println(end);
			
			if(end.getLest().equals(end.getParent())){
				movements.add("left");
				boardMap.getTime().setElapsedTime(boardMap.getTime().getElapsedTime() + end.getLest().getCost());
				boardMap.getTime().getCosts().add(new Float(end.getLest().getCost()));
				end = end.getLest();
			}
			if(end.getNorth().equals(end.getParent())){
				movements.add("down");
				boardMap.getTime().setElapsedTime(boardMap.getTime().getElapsedTime() + end.getNorth().getCost());
				boardMap.getTime().getCosts().add(new Float(end.getNorth().getCost()));
			
				end = end.getNorth();
			}
			if(end.getSouth().equals(end.getParent())){
				movements.add("up");
				
				boardMap.getTime().setElapsedTime(boardMap.getTime().getElapsedTime() + end.getSouth().getCost());
				boardMap.getTime().getCosts().add(new Float(end.getSouth().getCost()));
			
				end = end.getSouth();
			}
			if(end.getWest().equals(end.getParent())){
				movements.add("right");
				
				boardMap.getTime().setElapsedTime(boardMap.getTime().getElapsedTime() + end.getWest().getCost());
				boardMap.getTime().getCosts().add(new Float(end.getWest().getCost()));
			
				end = end.getWest();
			}
		}

		Collections.reverse(movements);
		Collections.reverse(boardMap.getTime().getCosts());
		return movements;
	}

	private static void aStarAlgorithm(ArrayList<Graph> openList, ArrayList<Graph> closedList, Graph start, Graph end, Graph current) {
		if(current==null){
			current = start;
			current.setParent(null);
		}
		if(current != null && current.getH() == 0){
			System.out.println("Finished executing A* search algorithm");
			return;
		}
		closedList.add(current);


		if(current.getLest() != null){
			if(!closedList.contains(current.getLest())){
				if(!openList.contains(current.getLest())){
					openList.add(current.getLest());
				}
				if((current.getG() + current.getLest().getCost() ) < current.getLest().getG() && (current.getLest().getG()!=0) || (current.getLest().getG()==0)){
					current.getLest().setParent(current);
					current.getLest().setG(current.getG() + current.getLest().getCost());
				}
				if(current.getG() + current.getLest().getCost() == current.getLest().getG() && (current.getLest().getG()!=0) && current.getNumberOfSteps() + 1 < current.getLest().getNumberOfSteps()){
					current.getLest().setParent(current);
				}
				
				current.getLest().setNumberOfSteps(current.getNumberOfSteps() + 1);
			}
		}

		if(current.getNorth() != null){
			if(!closedList.contains(current.getNorth())){
				if(!openList.contains(current.getNorth())){
					openList.add(current.getNorth());
				}
				if((current.getG() + current.getNorth().getCost() ) < current.getNorth().getG() && (current.getNorth().getG()!=0) || (current.getNorth().getG()==0)){
					current.getNorth().setParent(current);
					current.getNorth().setG(current.getG() + current.getNorth().getCost());
				}
				if(current.getG() + current.getNorth().getCost() == current.getNorth().getG() && (current.getNorth().getG()!=0) && current.getNumberOfSteps() + 1 < current.getNorth().getNumberOfSteps()){
					current.getNorth().setParent(current);
				}
		
				current.getNorth().setNumberOfSteps(current.getNumberOfSteps() + 1);
			}
		}

		if(current.getSouth() != null){
			if(!closedList.contains(current.getSouth())){
				if(!openList.contains(current.getSouth())){
					openList.add(current.getSouth());
				}
				if((current.getG() + current.getSouth().getCost() ) < current.getSouth().getG() && (current.getSouth().getG()!=0) || (current.getSouth().getG()==0)){
					current.getSouth().setParent(current);
					current.getSouth().setG(current.getG() + current.getSouth().getCost());
				}
				if(current.getG() + current.getSouth().getCost() == current.getSouth().getG() && (current.getSouth().getG()!=0) && current.getNumberOfSteps() + 1 < current.getSouth().getNumberOfSteps()){
					current.getSouth().setParent(current);
				}
				
				
				current.getSouth().setNumberOfSteps(current.getNumberOfSteps() + 1);
			}
		}

		if(current.getWest() != null){
			if(!closedList.contains(current.getWest())){
				if(!openList.contains(current.getWest())){
					openList.add(current.getWest());
				}
				if((current.getG() + current.getWest().getCost() ) < current.getWest().getG() && (current.getWest().getG()!=0) || (current.getWest().getG()==0)){
					current.getWest().setParent(current);
					current.getWest().setG(current.getG() + current.getWest().getCost());
				}
				if(current.getG() + current.getWest().getCost() == current.getWest().getG() && (current.getWest().getG()!=0) && current.getNumberOfSteps() + 1 < current.getWest().getNumberOfSteps()){
					current.getWest().setParent(current);
				}
				
				current.getWest().setNumberOfSteps(current.getNumberOfSteps() + 1);
			}
		}

		Collections.sort(openList, new Comparator<Graph>() {

			@Override
			public int compare(Graph arg0, Graph arg1) {
				if(arg0.getF()<arg1.getF()){
					return -1;
				}
				else if(arg0.getF() == arg1.getF()){
					if(arg0.getNumberOfSteps() < arg1.getNumberOfSteps()){
						return -1;
					}
					else if(arg0.getNumberOfSteps() == arg1.getNumberOfSteps()){
						return 0;
					}
					else{
						return 1;
					}

				}
				else
					return 1;
			}

		});

		Graph aux = openList.remove(0);

		MapPanelController.aStarAlgorithm(openList, closedList, start, end, aux);


	}
	
	public static ArrayList<Float> getCosts(){
		return boardMap.getTime().getCosts();
	}

}
