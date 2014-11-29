/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubham
 */import java.awt.Color;

import java.awt.GradientPaint;

import java.awt.Graphics;

import java.awt.Graphics2D;                                         // Imported Libraries

import javax.swing.JPanel;

import javax.swing.BorderFactory;

import javax.swing.border.LineBorder;

import javax.swing.border.TitledBorder;

 
public class Gradient extends JPanel {


protected void paintComponent( Graphics g ) {

if ( !isOpaque( ) ) {

super.paintComponent( g );

return;

}


Graphics2D g2d = (Graphics2D) g;


//to get height and width of the component

int w = getWidth();

int h = getHeight();


//generating two colors for gradient pattern

/*parameters are consentration of Red, Blue and Green color in HEX  format*/

Color color1 = new Color(12,0xeb,0xeb);

Color color2 = new Color(0xa2,0xbd,0xd8);


/*generating gradient pattern from two colors*/

GradientPaint gp = new GradientPaint( 0, 0, color1, 0, h, color2 );

g2d.setPaint( gp ); //set gradient color to graphics2D object

g2d.fillRect( 0, 0, w, h ); //filling color

setOpaque( false );


//Generating Titleborder

TitledBorder title;

title= BorderFactory.createTitledBorder(new LineBorder(new Color(0,51,204), 2, true), null, javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16), Color.BLACK);


super.setBorder(title);  //appling border to JPanel

super.paintComponent( g );

setOpaque( true );

}


}
