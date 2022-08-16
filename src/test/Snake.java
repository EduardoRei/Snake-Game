package test;

import java.util.ArrayList;
import java.awt.Rectangle;

public class Snake {
    private ArrayList<Rectangle> body;
    private int w = Game.widht;
    private int h = Game.height;
    private int d = Game.dimension;

    private String move; // NOTHING, UP, DOWN, LEFT, RIGHT
    
    public Snake(){
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(d, d);
        temp.setLocation(w/ 2 * d, h / 2 * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";
    }

    public void move(){
        if(move != "NOTHING"){
            Rectangle first = body.get(0);

            Rectangle temp = new Rectangle(d, d);

            if(move == "UP"){
                temp.setLocation(first.x, first.y - d);
            }
            else if(move == "DOWN"){
                temp.setLocation(first.x, first.y + d);
            }
            else if(move == "LEFT"){
                temp.setLocation(first.x - d, first.y);
            }
            else{
                temp.setLocation(first.x + d, first.y);
            }
            body.add(0, temp);
            body.remove(body.size()-1);
        }
    }

    public void grow(){
        Rectangle first = body.get(0);

        Rectangle temp = new Rectangle(d, d);

        if(move == "UP"){
            temp.setLocation(first.x, first.y - d);
        }
        else if(move == "DOWN"){
            temp.setLocation(first.x, first.y + d);
        }
        else if(move == "LEFT"){
            temp.setLocation(first.x - d, first.y);
        }
        else{
            temp.setLocation(first.x + d, first.y);
        }
        body.add(0, temp);
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX(){
        return body.get(0).x;
    }
    
    public int getY(){
        return body.get(0).y;
    }
    public String getMove() {
		return move;
	}

    public void up(){
        if(move != "DOWN"){
            move = "UP";
        }
    }
    public void down(){
        if(move != "UP"){
            move = "DOWN";
        }
    }
    public void left(){
        if(move !=  "RIGHT"){
            move = "LEFT";
        }
    }
    public void right(){
        if(move != "LEFT"){
            move = "RIGHT";
        }
    }

    
}
