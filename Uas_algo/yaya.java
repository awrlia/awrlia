import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.sql.*;

/**
 * Write a description of class yaya here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class yaya extends Actor
{
    /**
     * Act - do whatever the yaya wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
public void act()
    {
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_algo", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Move from game where ID = 1");
            while (rs.next()) {
                String key = rs.getString("Move");
                if (key.equals("w")) {
                    setLocation(getX(), getY()-5);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println("connection error 1");
                    }
                    
                }
                
                if (key.equals("s")) {
                    setLocation(getX(), getY()+5);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("connection error 2");
                    }
                }
                
                if (key.equals("d")) {
                    setLocation(getX()+5, getY());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("connection error 3");
                    }
                }
                
                if (key.equals("a")) {
                    setLocation(getX()-5, getY());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("connection error 4");
                    }
                }
            }
            conn.close();
        } catch (SQLException se) {
            System.out.println("connection error 5");
        }
    }
}
