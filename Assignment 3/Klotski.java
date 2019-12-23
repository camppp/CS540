/** 
 * This skeleton is just an example.
 * Feel free to change this skeleton or using better ideas to implement.  
 */

import java.util.*;

// implement the class of block if necessary
class Block {
    
}

class GameState {      
    public int[][] board = new int[5][4];
    public GameState parent = null;
    public int f = 0;
    public int h = 0;
    public int steps = 0;
    
    
    public GameState(int [][] inputBoard, int steps) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++)
                this.board[i][j] = inputBoard[i][j];
        this.steps = steps;
    }
    public int heur() {
        int result = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    result = Math.abs(i-3) + Math.abs(j-1);
                    return result;
                }
            }
        }
        return result;
    }
    public GameState(int [][] inputBoard) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++)
                this.board[i][j] = inputBoard[i][j];
    }
    
            
    // get all successors and return them in sorted order
    public List<GameState> getNextStates() {
        List<GameState> successors = new ArrayList<>(); 
        int counter = 0;
        int counter2 = 0;
        int counter1 = 0;
        int scounter = 0;
        int[][] record = new int[4][2];
        int[][] record2 = new int[2][2];
        for(int i = 0; i < board.length;i++) {
            for(int j = 0; j< board[0].length; j++) {
                if(board[i][j] ==  4) {
                    record[counter2][0] = i;
                    record[counter2][1] = j;
                    counter2++;
                }
                if(board[i][j] == 2) {
                    if(i == 0 || i == 4) {
                    }
                    else if(board[i-1][j] == 0) {
                        int[][] temp = this.board;
                        temp[i-1][j] = 2;
                        temp[i+1][j] = 0;
                        successors.add(new GameState(temp));
                        temp[i-1][j] = 0;
                        temp[i+1][j] = 2;
                        
                    }
                    else if(board[i+1][j] == 0) {
                        int[][] temp = this.board;
                        temp[i+1][j] = 2;
                        temp[i-1][j] = 0;
                        successors.add(new GameState(temp));
                        temp[i+1][j] = 0;
                        temp[i-1][j] = 2;
                    }
                    if(i == 0) {
                       if(j == 0&&board[i][j + 1] == 0 && board[i + 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j+1] = 2;
                            temp[i+1][j+1] = 2;
                            temp[i][j] = 0;
                            temp[i+1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j+1] = 0;
                            temp[i+1][j+1] = 0;
                            temp[i][j] = 2;
                            temp[i+1][j] = 2;
                       }
                       else if(j == 3&&board[i][j - 1] == 0 && board[i + 1][j - 1] == 0) {
                           int[][] temp = this.board;
                           temp[i][j-1] = 2;
                           temp[i+1][j-1] = 2;
                           temp[i][j] = 0;
                           temp[i+1][j] = 0;
                           successors.add(new GameState(temp));
                           temp[i][j-1] = 0;
                           temp[i+1][j-1] = 0;
                           temp[i][j] = 2;
                           temp[i+1][j] = 2;
                      }
                    }
                    else if(i == 4) {
                        if(j == 0&&board[i][j + 1] == 0 && board[i - 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j+1] = 2;
                            temp[i-1][j+1] = 2;
                            temp[i][j] = 0;
                            temp[i-1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j+1] = 0;
                            temp[i-1][j+1] = 0;
                            temp[i][j] = 2;
                            temp[i-1][j] = 2;
                       }
                       else if(j == 3&&board[i][j - 1] == 0 && board[i - 1][j - 1] == 0) {
                           int[][] temp = this.board;
                           temp[i][j-1] = 2;
                           temp[i-1][j-1] = 2;
                           temp[i][j] = 0;
                           temp[i-1][j] = 0;
                           successors.add(new GameState(temp));
                           temp[i][j-1] = 0;
                           temp[i-1][j-1] = 0;
                           temp[i][j] = 2;
                           temp[i-1][j] = 2;
                      }
                    }
                    else if((i == 3 && j == 0&& board[i+1][0] == 2) 
                                    || (i==1&&j==0&&board[i-1][0] == 2)
                                    || (i==1&&j==3&&board[i-1][3] == 2)
                                    || (i==3&&j==3&&board[i+1][3] == 2)) {   
                    }
                    else if(i == 1) {
                        if(j == 0 && board[i][j + 1] == 0 && board[i + 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j+1] = 2;
                            temp[i+1][j+1] = 2;
                            temp[i][j] = 0;
                            temp[i+1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j+1] = 0;
                            temp[i+1][j+1] = 0;
                            temp[i][j] = 2;
                            temp[i+1][j] = 2;
                        }
                        else if(j == 3 && board[i][j - 1] == 0 && board[i + 1][j - 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j-1] = 2;
                            temp[i+1][j-1] = 2;
                            temp[i][j] = 0;
                            temp[i+1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j-1] = 0;
                            temp[i+1][j-1] = 0;
                            temp[i][j] = 2;
                            temp[i+1][j] = 2;
                        }
                        else {
                            if(board[0][j] == 2) {
                                if(board[0][j + 1] == 0 && board[1][j + 1] == 0) {
                                    int[][] temp = this.board;
                                    temp[i-1][j+1] = 2;
                                    temp[i][j+1] = 2;
                                    temp[i][j] = 0;
                                    temp[i-1][j] = 0;
                                    successors.add(new GameState(temp));
                                    temp[i-1][j+1] = 0;
                                    temp[i][j+1] = 0;
                                    temp[i][j] = 2;
                                    temp[i-1][j] = 2;
                                }
                                else if(board[0][j - 1] == 0 && board[1][j - 1] == 0) {
                                    int[][] temp = this.board;
                                    temp[i][j-1] = 2;
                                    temp[i-1][j-1] = 2;
                                    temp[i][j] = 0;
                                    temp[i-1][j] = 0;
                                    successors.add(new GameState(temp));
                                    temp[i][j-1] = 0;
                                    temp[i-1][j-1] = 0;
                                    temp[i][j] = 2;
                                    temp[i-1][j] = 2;
                                }
                                
                            }
                            else if (j==0&&board[i][j + 1] == 0 && board[i - 1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+1] = 2;
                                temp[i-1][j+1] = 2;
                                temp[i][j] = 0;
                                temp[i-1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i][j+1] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i][j] = 2;
                                temp[i-1][j] = 2;
                            }
                            else if (j==3&&board[i][j - 1] == 0 && board[i - 1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 2;
                                temp[i-1][j-1] = 2;
                                temp[i][j] = 0;
                                temp[i-1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i][j-1] = 0;
                                temp[i-1][j-1] = 0;
                                temp[i][j] = 2;
                                temp[i-1][j] = 2;
                            }
                            else if(j != 3&&board[i][j + 1] == 0 && board[i + 1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+1] = 2;
                                temp[i+1][j+1] = 2;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                temp[i][j] = 2;
                                temp[i+1][j] = 2;
                            }
                            else if(j != 0&&board[i][j - 1] == 0 && board[i + 1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 2;
                                temp[i+1][j-1] = 2;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j] = 2;
                                temp[i+1][j] = 2;
                            }
                        }
                    }
                    else if(i == 3) {
                        if(board[4][j] == 2) {
                            if(board[4][j + 1] == 0 && board[3][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+1][j+1] = 2;
                                temp[i][j+1] = 2;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i+1][j+1] = 0;
                                temp[i][j+1] = 0;
                                temp[i][j] = 2;
                                temp[i+1][j] = 2;
                            }
                            else if(board[4][j - 1] == 0 && board[3][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 2;
                                temp[i+1][j-1] = 2;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j] = 2;
                                temp[i+1][j] = 2;
                            }
                            
                        }
                        else if (j==0&&board[i][j + 1] == 0 && board[i - 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j+1] = 2;
                            temp[i-1][j+1] = 2;
                            temp[i][j] = 0;
                            temp[i-1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j+1] = 0;
                            temp[i-1][j+1] = 0;
                            temp[i][j] = 2;
                            temp[i-1][j] = 2;
                        }
                        else if (j==3&&board[i][j - 1] == 0 && board[i - 1][j - 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j-1] = 2;
                            temp[i-1][j-1] = 2;
                            temp[i][j] = 0;
                            temp[i-1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j-1] = 0;
                            temp[i-1][j-1] = 0;
                            temp[i][j] = 2;
                            temp[i-1][j] = 2;
                        }
                        else if(j != 3&&board[i][j + 1] == 0 && board[i - 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j+1] = 2;
                            temp[i-1][j+1] = 2;
                            temp[i][j] = 0;
                            temp[i-1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j+1] = 0;
                            temp[i-1][j+1] = 0;
                            temp[i][j] = 2;
                            temp[i-1][j] = 2;
                        }
                        else if(j != 0&&board[i][j - 1] == 0 && board[i - 1][j - 1] == 0) {
                            int[][] temp = this.board;
                            temp[i][j-1] = 2;
                            temp[i-1][j-1] = 2;
                            temp[i][j] = 0;
                            temp[i-1][j] = 0;
                            successors.add(new GameState(temp));
                            temp[i][j-1] = 0;
                            temp[i-1][j-1] = 0;
                            temp[i][j] = 2;
                            temp[i-1][j] = 2;
                        }
                    }
                }
                if(board[i][j] == 3) {
                    counter1++;                
                    if(counter1 == 1) {
                    if(j == 0 && board[i][j+2] ==0) {
                        int[][] temp = this.board;
                        temp[i][j+2] = 3;
                        temp[i][j] = 0;
                        successors.add(new GameState(temp));
                        temp[i][j+2] = 0;
                        temp[i][j] = 3;
                    }
                    else if(j == 2&& board[i][j-1] ==0) {
                        int[][] temp = this.board;
                        temp[i][j-1] = 3;
                        temp[i][j+1] = 0;
                        successors.add(new GameState(temp));
                        temp[i][j-1] = 0;
                        temp[i][j+1] = 3;
                    }
                    else {
                        if(j == 1&&board[i][j-1] ==0) {
                        int[][] temp = this.board;
                        temp[i][j-1] = 3;
                        temp[i][j+1] = 0;
                        successors.add(new GameState(temp));
                        temp[i][j-1] = 0;
                        temp[i][j+1] = 3;
                        }
                        if(j == 1&&board[i][j+2] == 0) {
                        int[][] temp = this.board;
                        temp[i][j+2] = 3;
                        temp[i][j] = 0;
                        successors.add(new GameState(temp));
                        temp[i][j+2] = 0;
                        temp[i][j] = 3;
                        }
                    }
                    if(i == 0) {
                       if(board[i + 1][j] == 0 && board[i + 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i+1][j] = 3;
                            temp[i+1][j+1] = 3;
                            temp[i][j] = 0;
                            temp[i][j+1] = 0;
                            successors.add(new GameState(temp));
                            temp[i+1][j] = 0;
                            temp[i+1][j+1] = 0;
                            temp[i][j] = 3;
                            temp[i][j+1] = 3;
                       }
                    }
                    else if(i == 4) {
                        if(board[i-1][j] == 0 && board[i - 1][j + 1] == 0) {
                             int[][] temp = this.board;
                             temp[i-1][j] = 3;
                             temp[i-1][j+1] = 3;
                             temp[i][j] = 0;
                             temp[i][j+1] = 0;
                             successors.add(new GameState(temp));
                             temp[i-1][j] = 0;
                             temp[i-1][j+1] = 0;
                             temp[i][j] = 3;
                             temp[i][j+1] = 3;
                        }
                    }
                    else {
                        if(board[i + 1][j] == 0 && board[i + 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i+1][j] = 3;
                            temp[i+1][j+1] = 3;
                            temp[i][j] = 0;
                            temp[i][j+1] = 0;
                            successors.add(new GameState(temp));
                            temp[i+1][j] = 0;
                            temp[i+1][j+1] = 0;
                            temp[i][j] = 3;
                            temp[i][j+1] = 3;
                       }
                        if(board[i-1][j] == 0 && board[i - 1][j + 1] == 0) {
                            int[][] temp = this.board;
                            temp[i-1][j] = 3;
                            temp[i-1][j+1] = 3;
                            temp[i][j] = 0;
                            temp[i][j+1] = 0;
                            successors.add(new GameState(temp));
                            temp[i-1][j] = 0;
                            temp[i-1][j+1] = 0;
                            temp[i][j] = 3;
                            temp[i][j+1] = 3;
                       }
                    }
                    }
                }
                if(board[i][j] == 1) {
                    counter++;    
                    if(counter == 1){
                        if(i == 0 && j == 0) {
                            if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                        else if(i == 3 && j == 2) {
                            if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 1;
                                temp[i+1][j-1] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                            else if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            }
                        }
                        else if(i == 3 && j == 0) {
                            if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            } 
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                        else if(i == 0 && j == 2) {
                            if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 1;
                                temp[i+1][j-1] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                            else if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                        }
                        else if(i == 0 && j>0 && j<3) {
                            if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 1;
                                temp[i+1][j-1] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                            else if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                        else if(i == 3 && j>0 && j<3) {
                            if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            } 
                            else if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 1;
                                temp[i+1][j-1] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                        else if(j == 0 && i>0 && i<3) {
                            if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            } 
                            else if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                        else if(j == 2 && i>0 && i<3) {
                            if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            } 
                            else if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                            else if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-1] = 1;
                                temp[i+1][j-1] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-1] = 0;
                                temp[i+1][j-1] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                        }
                        else {
                            if(board[i-1][j] == 0 && board[i-1][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i-1][j] = 1;
                                temp[i-1][j+1] = 1;
                                temp[i+1][j] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//up
                                temp[i-1][j] = 0;
                                temp[i-1][j+1] = 0;
                                temp[i+1][j] = 1;
                                temp[i+1][j+1] = 1;
                            } 
                            else if(board[i+2][j] == 0 && board[i+2][j + 1] == 0) {
                                int[][] temp = this.board;
                                temp[i+2][j] = 1;
                                temp[i+2][j+1] = 1;
                                temp[i][j] = 0;
                                temp[i][j+1] = 0;
                                successors.add(new GameState(temp));//down
                                temp[i+2][j] = 0;
                                temp[i+2][j+1] = 0;
                                temp[i][j] = 1;
                                temp[i][j+1] = 1;
                            }
                            else if(board[i][j-1] == 0 && board[i+1][j - 1] == 0) {
                                int[][] temp = this.board;
                                temp[i][j-2] = 1;
                                temp[i+1][j-2] = 1;
                                temp[i][j+1] = 0;
                                temp[i+1][j+1] = 0;
                                successors.add(new GameState(temp));//left
                                temp[i][j-2] = 0;
                                temp[i+1][j-2] = 0;
                                temp[i][j+1] = 1;
                                temp[i+1][j+1] = 1;
                            }
                            else if(board[i][j+2] == 0 && board[i+1][j + 2] == 0) {
                                int[][] temp = this.board;
                                temp[i][j+2] = 1;
                                temp[i+1][j+2] = 1;
                                temp[i][j] = 0;
                                temp[i+1][j] = 0;
                                successors.add(new GameState(temp));//right
                                temp[i][j+2] = 0;
                                temp[i+1][j+2] = 0;
                                temp[i][j] = 1;
                                temp[i+1][j] = 1;
                            }
                        }
                    }
                }
                if(board[i][j] == 0) {
                    record2[scounter][0] = i;
                    record2[scounter][1] = j;
                    scounter++;
                }   
            }
            
        }
        for(int c = 0; c < 4;c++) {
                    int[][] temp = this.board.clone();
                    temp[record[c][0]][record[c][1]] = 0;
                    temp[record2[0][0]][record2[0][1]] = 4;
                    successors.add(new GameState(temp));
                    temp[record[c][0]][record[c][1]] = 4;
                    temp[record2[0][0]][record2[0][1]] = 0;
                    temp[record[c][0]][record[c][1]] = 0;
                    temp[record2[1][0]][record2[1][1]] = 4;
                    successors.add(new GameState(temp));
                    temp[record[c][0]][record[c][1]] = 4;
                    temp[record2[1][0]][record2[1][1]] = 0;
        }
        return successors;
    }

    // return the 20-digit number as ID
    public String getStateID() {  
        String s = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                s += this.board[i][j];
        }
        return s;
    }

    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(this.board[i][j]);
            System.out.println();
        }
    }

    // check whether the current state is the goal
    public boolean goalCheck() {        

        if(this.board[3][1] == 1 &&this.board[3][2] == 1&&this.board[4][1] == 1&&this.board[4][2] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    public int hashCode() {
        return this.getStateID().hashCode();
    }
    // add new methods for the GameState if necessary        

}

class AStarSearch{
    Queue<GameState> openSet;
    Set<GameState> closedSet;
    HashMap<String, Integer> openStateCost;

    //Comparator for the GameState
    public Comparator<GameState> stateComparator = new Comparator<GameState>() {
        @Override
        public int compare(GameState o1, GameState o2) {
            if (o1.f - o2.f != 0)
                return o1.f - o2.f;
            else
                return o1.getStateID().compareTo(o2.getStateID());
        }
    };   

    // print the states of board in open set
    public void printOpenList(int flag, GameState state) throws Exception {
        if(flag == 400) {
        System.out.println("OPEN");
        for(GameState k: openSet) {
            System.out.println(k.getStateID());
            k.printBoard();
            k.f = k.steps + k.heur();
            System.out.println(k.f + " " + k.steps + " " + k.heur());
            if(k.parent!=null) {
                System.out.println(k.parent.getStateID());
            }
            else {
                System.out.println("null");
            }
        }
        }
        if(flag == 200) {
            System.out.println("OPEN");
            for(GameState k: openSet) {
                System.out.println(k.getStateID());
                k.printBoard();
                System.out.println(k.f + " " + k.steps + " " + 0);
                if(k.parent!=null) {
                    System.out.println(k.parent.getStateID());
                }
                else {
                    System.out.println("null");
                }
            }
            }
        
    }

    public void printClosedList(int flag, GameState state) {
        if(flag == 400) {
        System.out.println("CLOSED");
        for(GameState k: closedSet) {
            System.out.println(k.getStateID());
            k.printBoard();
            k.f = k.steps + k.heur();
            System.out.println(k.f + " " + k.steps + " " + k.heur());
            if(k.parent!=null) {
                System.out.println(k.parent.getStateID());
            }
            else {
                System.out.println("null");
            }
        }
        }
        if(flag == 200) {
            System.out.println("CLOSED");
            for(GameState k: closedSet) {
                System.out.println(k.getStateID());
                k.printBoard();
                System.out.println(k.f + " " + k.steps + " " + 0);
                if(k.parent!=null) {
                    System.out.println(k.parent.getStateID());
                }
                else {
                    System.out.println("null");
                }
            }
        }
        
    }

    // implement the A* search
    public GameState aStarSearch(int flag, GameState state) throws Exception {   
        // feel free to using other data structures if necessary
        openSet = new PriorityQueue<>(stateComparator);
        closedSet = new HashSet<>();
        openStateCost = new HashMap<>();
        int goalCheck = 0;
        int maxOPEN = -1;
        int maxCLOSED = -1;
        int steps = 0;
        int iteration = 0;
        
        if (flag == 400 || flag == 500) {
            state.f = state.steps + state.heur();
        }
        openSet.offer(state);
        openStateCost.put(state.getStateID(), state.f);
        maxOPEN = Math.max(maxOPEN, openSet.size());
        while (!openSet.isEmpty()) {
            GameState u = openSet.remove();
            closedSet.add(u);
            maxCLOSED = Math.max(maxCLOSED, closedSet.size());
            if (flag == 200 || flag == 400) {
                int heur = 0;
                if (flag == 400) {
                    heur = u.heur();
                }
                iteration++;
                System.out.println("iteration " + iteration);
                System.out.println(u.getStateID());
                u.printBoard();
                System.out.println(u.f + " " + u.steps + " " + heur);
                if (u.parent == null) {
                    System.out.println("null");
                } else {
                    System.out.println(u.parent.getStateID());
                }
            }
            
            goalCheck++;
            if (u.goalCheck()) {
                if (flag == 300 || flag == 500) {
                    steps = u.steps;
                    Stack<GameState> pathFinder = new Stack<>();
                    pathFinder.push(u);
                    GameState parent = u.parent;
                    while (parent != null) {
                        u = parent;
                        pathFinder.push(u);
                        parent = u.parent;
                    }
                    while (!pathFinder.isEmpty()) {
                        pathFinder.pop().printBoard();
                        System.out.println();
                    }
                    System.out.println("goalCheckTimes " + goalCheck);
                    System.out.println("maxOPENSize " + maxOPEN);
                    System.out.println("maxCLOSEDSize " + (maxCLOSED - 1));
                    System.out.println("steps " + steps);
                }
                break;
            } else {
                for (GameState v : u.getNextStates()) {
                    int h = 0;
                    if (flag == 400 || flag == 500) {
                        h = v.heur();
                    }
                    v.parent = u;
                    v.steps = u.steps + 1;
                    v.f = u.steps + h + 1;
                    boolean contains = false;
                    boolean contains1 = false;
                    for(GameState x: closedSet) {
                        if(x.getStateID().equals(v.getStateID())) {
                            contains1 = true;
                            break;
                        }
                    }
                    for(GameState x: openSet) {
                        if(x.getStateID().equals(v.getStateID())) {
                            contains = true;
                            break;
                        }
                    }
                    if(!contains1) {
                    if (!contains) {
                        openSet.offer(v);
                        openStateCost.put(v.getStateID(), v.f);
                        maxOPEN = Math.max(maxOPEN, openSet.size());
                    } else if (openStateCost.get(v.getStateID()) <= v.f) {
                        continue;
                    } else {
                        for(GameState g: openSet) {
                            if(g.getStateID().equals(u.getStateID())){
                                openSet.remove(g);
                                break;
                            }
                        }
                        openSet.offer(v);
                        openStateCost.put(v.getStateID(), v.f);
                        maxOPEN = Math.max(maxOPEN, openSet.size());
                    }
                    }
                }
            }
            if (flag == 200 || flag == 400) {
                printOpenList(flag, state);
                printClosedList(flag, state);
            }
        }
        return state;
    }    

    // add more methods for the A* search if necessary
}

public class Klotski {   
    public static void printNextStates(GameState s) {
        List<GameState> states = s.getNextStates();
        Collections.sort(states, new Comparator<GameState>() {
            @Override
            public int compare(GameState a, GameState b) {
                return (a.getStateID()).compareTo(b.getStateID());
            }
        });
        for (GameState state: states) {
            state.printBoard();
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 21) {
            return;
        }
        int flag = Integer.parseInt(args[0]);
        int[][] board = new int[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = Integer.parseInt(args[i * 4 + j + 1]);
            }                
        }        
        GameState s = new GameState(board, 0);

        if (flag == 100) {
            printNextStates(s);
            return;
        }
        if (flag == 200) {
            AStarSearch search = new AStarSearch();
            search.aStarSearch(flag, s);
            return;
        }
        if (flag == 300) {
            AStarSearch search = new AStarSearch();
            search.aStarSearch(flag, s);
            return;
        }
        if (flag == 400) {
            AStarSearch search = new AStarSearch();
            search.aStarSearch(flag, s);
            return;
        }
        if (flag == 500) {
            AStarSearch search = new AStarSearch();
            search.aStarSearch(flag, s);
            return;
        }
    }

}
