package com.company.Kirchik;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2ES3;
import com.jogamp.opengl.glu.GLU;

import static com.jogamp.opengl.GL.GL_TRIANGLES;
import static com.jogamp.opengl.GL2.GL_POLYGON;

public class Drawing {
    protected static void setup( GL2 gl2, int width, int height ) {
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // начало системы координат в левом нижнем углу с шириной и высотой, как и окно
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
    }

    protected static void render( GL2 gl2, int width, int height ) {
        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );

        //рисуем треугольник, заполняющий окно
        gl2.glLoadIdentity();


        gl2.glColor3f(1, 1, 0);
        gl2.glBegin( gl2.GL_QUADS );
        gl2.glVertex2f(0, 0);
        gl2.glVertex2f(0, height);
        gl2.glVertex2f(width, height);
        gl2.glVertex2f(width, 0);
        gl2.glEnd();


        gl2.glColor3f(0, 1, 0);
        gl2.glBegin( GL_TRIANGLES );
            gl2.glVertex2f(0, 0);
            gl2.glVertex2f(0, height);
            gl2.glVertex2f(width * 4 / 5, height);
        gl2.glEnd();

        gl2.glColor3f(1, 0, 0);
        gl2.glBegin( GL_TRIANGLES );
            gl2.glVertex2f(width, height);
            gl2.glVertex2f(width, 0);
            gl2.glVertex2f(width * 1 / 5, 0);
        gl2.glEnd();
    }
}