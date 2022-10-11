using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using SharpGL;

namespace SharpGL
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        float rtri = 0;
        float rquad = 0;

        private void openGLControl1_OpenGLDraw(object sender, RenderEventArgs args)
        {
            OpenGL gl = this.openGLControl1.OpenGL;
            gl.Clear(OpenGL.GL_COLOR_BUFFER_BIT | OpenGL.GL_DEPTH_BUFFER_BIT);

            /////////////////ПИРАМИДКА
            
            gl.LoadIdentity();
            gl.Translate(0.0f, 1.5f, -6.0f);
            gl.Rotate(rtri, 0.0f, 1.0f, 0.0f);
                  
            gl.Color(1.0f, 1.0f, 0.0f, 0.0f);
            gl.Begin(OpenGL.GL_TRIANGLES);

            // Front
            gl.Vertex(0.0f, 1.0f, 0.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            gl.Vertex(1.0f, -1.0f, 1.0f);
            
            // Right
            gl.Vertex(0.0f, 1.0f, 0.0f);
            gl.Vertex(1.0f, -1.0f, -1.0f);
            gl.Vertex(1.0f, -1.0f, 1.0f);
            
            // Back
            gl.Vertex(0.0f, 1.0f, 0.0f);
            gl.Vertex(1.0f, -1.0f, -1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);
            
            // Left
            gl.Vertex(0.0f, 1.0f, 0.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);

            //Bottom
            gl.Color(0.1f, 0.0f, 0.0f);
            gl.Vertex(1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);

            gl.Vertex(1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);
            gl.Vertex(1.0f, -1.0f, -1.0f);

            gl.End();



            //////////////КУБИК
           
            gl.LoadIdentity();
            gl.Translate(0.0f, 0.0f, -8.5f);
            gl.Rotate(rquad, 0.0f, 1.0f, 0.0f);
                  
            gl.Color(1.0f, 0.5f, 0.0f, 0.0f);
            gl.Begin(OpenGL.GL_QUADS);
            
            // Bottom
            gl.Vertex(1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);
            gl.Vertex(1.0f, -1.0f, -1.0f);
            
            // Front
            gl.Vertex(1.0f, 1.0f, 1.0f);
            gl.Vertex(-1.0f, 1.0f, 1.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            gl.Vertex(1.0f, -1.0f, 1.0f);
            
            // Back
            gl.Vertex(1.0f, -1.0f, -1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);
            gl.Vertex(-1.0f, 1.0f, -1.0f);
            gl.Vertex(1.0f, 1.0f, -1.0f);
            
            // Left
            gl.Vertex(-1.0f, 1.0f, 1.0f);
            gl.Vertex(-1.0f, 1.0f, -1.0f);
            gl.Vertex(-1.0f, -1.0f, -1.0f);
            gl.Vertex(-1.0f, -1.0f, 1.0f);
            
            // Right
            gl.Vertex(1.0f, 1.0f, -1.0f);
            gl.Vertex(1.0f, 1.0f, 1.0f);
            gl.Vertex(1.0f, -1.0f, 1.0f);
            gl.Vertex(1.0f, -1.0f, -1.0f);

            // Top
            gl.Color(0.1f, 0.0f, 0.0f);
            gl.Vertex(1.0f, 1.0f, -1.0f);
            gl.Vertex(-1.0f, 1.0f, -1.0f);
            gl.Vertex(-1.0f, 1.0f, 1.0f);
            gl.Vertex(1.0f, 1.0f, 1.0f);

            // Front door
            gl.Color(0.1f, 0.1f, 0.1f);
            gl.Vertex(1.0f, -1.0f, 1.05f);
            gl.Vertex(0.0f, -1.0f, 1.05f);
            gl.Vertex(0.0f, 0.5f, 1.05f);
            gl.Vertex(1.0f, 0.5f, 1.05f);

            // Back window
            gl.Color(0.0f, 0.0f, 1.0f);
            gl.Vertex(0.5f, -0.5f, -1.05f);
            gl.Vertex(-0.5f, -0.5f, -1.05f);
            gl.Vertex(-0.5f, 0.5f, -1.05f);
            gl.Vertex(0.5f, 0.5f, -1.05f);

            gl.End();
       
            // Контроль полной отрисовки следующего изображения
            gl.Flush();

            // Меняем угол поворота 
            rtri -= 3.0f;
            rquad -= 3.0f;

        }
    }
}