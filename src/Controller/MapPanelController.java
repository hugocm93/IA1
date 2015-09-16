package Controller;

import java.awt.Point;
import java.util.ArrayList;

import Model.BoardMap;
import Model.Graph;

public class MapPanelController {
	
	private static BoardMap boardMap;
	
	public MapPanelController() {
		super();
		
		boardMap = new BoardMap();
	}

	public static int getIndexOfImage(int i, int j){
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
				{
					Graph aux = boardMap.getGraphMap().get(new Point(i,j));
					Graph aux2 = null;

					int x = boardMap.getEnd().x - i;
					int y = boardMap.getEnd().y - j;

					int h = 0;

					if(x<0){
						Graph var = aux;
						for(int k=0 ; k<x*(-1);k++){
							h += var.getWest().getCost();
							aux2 = var;
							var = var.getWest();
						}
					}
					else if(x>0){
						Graph var = aux;
						for(int k=0 ; k<x;k++){
							h += var.getLest().getCost();
							aux2 = var;
							var = var.getLest();
						}
					}
					if(x==0){
						aux2 = boardMap.getGraphMap().get(new Point(i,j));
					}
					aux =  aux2;

					if(y<0){
						Graph var = aux;
						for(int k=0 ; k<y*(-1);k++){
							h += var.getNorth().getCost();
							var = var.getNorth();
						}
					}
					else if(y>0){
						Graph var = aux;
						for(int k=0 ; k<y;k++){			
							h += var.getSouth().getCost();
							var = var.getSouth();
						}
					}
					boardMap.getGraphMap().get(new Point(i,j)).setH(h);

				}
			}
	}

	public static void printMap(){
		Graph nextl = boardMap.getGraphMap().get(new Point(0,0)).getLest();
		while(nextl != null){
			Graph previous = null;
			while(nextl != null){
				System.out.printf("%d ",nextl.getCost());
				//System.out.printf("%d ",nextl.getH());
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
		ArrayList<String> movements = new ArrayList<String>();
		movements.add("left");
		movements.add("left");
		movements.add("up");
		movements.add("left");
		movements.add("down");
		movements.add("left");
		
		
		return movements;
	}

}
