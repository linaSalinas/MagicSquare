package model;

public class MagicSquare {
	
	private int [][] matrix;
	private int order;

	public final static String UPPER_CENTRAL = "U";
	public final static String CENTRAL_SIDE = "L";
	public final static String CENTRAL_RIGHT = "R";
	public final static String LOWER_CENTRAL = "C";
	
	public final static String N_O = "n.o";
	public final static String N_E = "n.e";
	public final static String S_O = "s.o";
	public final static String S_E = "s.e";
//_______________________________________________________________________________________________________________________________	

	public MagicSquare(int order) {
		//this.order = order;
	}
//_______________________________________________________________________________________________________________________________	

	public void setOrder(int order) {
		
		
		matrix = new int [order][order];
		
	}
	
//_______________________________________________________________________________________________________________________________	

	public void fillMatrix(String direction, String location){
		
		int tamano = matrix.length;
		int position = tamano/2;
		
		int rowActual = 0;
		int colActual = 0;
		
		if(location.equals(UPPER_CENTRAL)) {
			
			matrix [0][position]=1;
			
			rowActual = 0;
			colActual = position;
			
		}
		else if(location.equals(LOWER_CENTRAL)) {
			
			matrix [tamano-1] [position] =1;
			
			rowActual = tamano -1;
			colActual = position;
		}
		else if(location.equals(CENTRAL_SIDE)) {
			
			matrix [position][0] = 1;
			
			rowActual = position;
			colActual = 0;
		}
		else if(location.equals(CENTRAL_RIGHT)) {
			
			matrix [position][tamano-1] = 1;
			
			rowActual = position;
			colActual = tamano-1;
		}
		
		int rowAnterior = 0;
		int colAnterior = 0;
		
		for(int i = 1; i < (tamano*tamano);i++) {
			
			rowAnterior = rowActual;
			colAnterior = colActual;	
			
			    if(direction.equals(N_O) || direction.equals(S_O)) {
				
				rowActual -=1; 
				
				}
				
			    else if(direction.equals(N_E) || direction.equals(S_E)) {
			    
    			    rowActual ++;
                }
			
			    if(rowActual < 0) {
					
					rowActual = tamano-1;
			    }
			    
			    if(rowActual > tamano -1) {
			    	
			    	rowActual = 0;
			    	
			    }

				if(direction.equals(N_O) || direction.equals(S_O)) {
					
					colActual -=1;
				}
				
				else if(direction.equals(N_E) || direction.equals(S_E)) {
					
					colActual -=1;
				}
				
                if(colActual <0) {
					
					colActual = tamano-1;
                }
                
                if (colActual > tamano-1) {
                	
                	colActual = 0;
                	
                }
                if(matrix[rowActual][colActual] !=0) {
                	rowActual = rowAnterior;
                	colActual = colAnterior;
                	rowActual++;
                	
                }
                matrix [rowActual][colActual] = i+1;
			}
	
		}
//_______________________________________________________________________________________________________________________________________
	
	public int[][] getMatrix() {
		return matrix;
	}
//_______________________________________________________________________________________________________________________________________
	
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
}