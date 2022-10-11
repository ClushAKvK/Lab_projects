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


           
            gl.LoadIdentity();
            gl.Translate(0.0f, -0.2f, -4.5f);
            gl.Rotate(rquad, 0.0f, 1.0f, 0.0f);
                  //0.0f, 1.0f, 1.0f, 1.0f
            gl.Color(0.0f, 0.0f, 0.0f);
            gl.Begin(OpenGL.GL_QUADS);
            
            //////////////////Middle box
            // Front
            gl.Vertex(0.8f, -0.4f, 0.4f);
            gl.Vertex(-0.8f, -0.4f, 0.4f);
            gl.Vertex(-0.8f, 0.4f, 0.4f);
            gl.Vertex(0.8f, 0.4f, 0.4f);
            

            // Back
            gl.Vertex(0.8f, -0.4f, -0.4f);
            gl.Vertex(-0.8f, -0.4f, -0.4f);
            gl.Vertex(-0.8f, 0.4f, -0.4f);
            gl.Vertex(0.8f, 0.4f, -0.4f);
            

            // Left
            gl.Vertex(-0.8f, -0.4f, 0.4f);
            gl.Vertex(-0.8f, 0.4f, 0.4f);
            gl.Vertex(-0.8f, 0.4f, -0.4f);
            gl.Vertex(-0.8f, -0.4f, -0.4f);
            

            // Right
            gl.Vertex(0.8f, -0.4f, 0.4f);
            gl.Vertex(0.8f, 0.4f, 0.4f);
            gl.Vertex(0.8f, 0.4f, -0.4f);
            gl.Vertex(0.8f, -0.4f, -0.4f);

            
            // Top
            gl.Vertex(0.8f, 0.4f, 0.4f);
            gl.Vertex(-0.8f, 0.4f, 0.4f);
            gl.Vertex(-0.8f, 0.4f, -0.4f);
            gl.Vertex(0.8f, 0.4f, -0.4f);


            
            // Bottom
            gl.Vertex(0.8f, -0.4f, 0.4f);
            gl.Vertex(-0.8f, -0.4f, 0.4f);
            gl.Vertex(-0.8f, -0.4f, -0.4f);
            gl.Vertex(0.8f, -0.4f, -0.4f);

           
            
            //////////////////Left box
            // Front
            gl.Vertex(-0.8f, -0.4f, 0.4f);
            gl.Vertex(-1.4f, -0.4f, 0.4f);
            gl.Vertex(-1.4f, 0.0f, 0.4f);
            gl.Vertex(-0.8f, 0.0f, 0.4f);
            

            // Back
            gl.Vertex(-0.8f, -0.4f, -0.4f);
            gl.Vertex(-1.4f, -0.4f, -0.4f);
            gl.Vertex(-1.4f, 0.0f, -0.4f);
            gl.Vertex(-0.8f, 0.0f, -0.4f);
            

            // Left
            gl.Vertex(-1.4f, -0.4f, 0.4f);
            gl.Vertex(-1.4f, 0.0f, 0.4f);
            gl.Vertex(-1.4f, 0.0f, -0.4f);
            gl.Vertex(-1.4f, -0.4f, -0.4f);
            

            // Right
            gl.Vertex(-0.801f, -0.4f, 0.4f);
            gl.Vertex(-0.801f, 0.0f, 0.4f);
            gl.Vertex(-0.801f, 0.0f, -0.4f);
            gl.Vertex(-0.801f, -0.4f, -0.4f);

            
            // Top
            gl.Vertex(-1.4f, 0.0f, 0.4f);
            gl.Vertex(-1.4f, 0.0f, -0.4f);
            gl.Vertex(-0.8f, 0.0f, -0.4f);
            gl.Vertex(-0.8f, 0.0f, 0.4f);


            // Bottom
            gl.Vertex(-1.4f, -0.4f, 0.4f);
            gl.Vertex(-1.4f, -0.4f, -0.4f);
            gl.Vertex(-0.8f, -0.4f, -0.4f);
            gl.Vertex(-0.8f, -0.4f, 0.4f);


            //////////////////Right box
            // Front
            gl.Vertex(0.8f, -0.4f, 0.4f);
            gl.Vertex(1.8f, -0.4f, 0.4f);
            gl.Vertex(1.8f, 0.0f, 0.4f);
            gl.Vertex(0.8f, 0.0f, 0.4f);
            

            // Back
            gl.Vertex(0.8f, -0.4f, -0.4f);
            gl.Vertex(1.8f, -0.4f, -0.4f);
            gl.Vertex(1.8f, 0.0f, -0.4f);
            gl.Vertex(0.8f, 0.0f, -0.4f);
            

            // Left
            gl.Vertex(0.801f, -0.4f, 0.4f);
            gl.Vertex(0.801f, 0.0f, 0.4f);
            gl.Vertex(0.801f, 0.0f, -0.4f);
            gl.Vertex(0.801f, -0.4f, -0.4f);
            

            // Right
            gl.Vertex(1.8f, -0.4f, 0.4f);
            gl.Vertex(1.8f, 0.0f, 0.4f);
            gl.Vertex(1.8f, 0.0f, -0.4f);
            gl.Vertex(1.8f, -0.4f, -0.4f);

            
            // Top
            gl.Vertex(1.8f, 0.0f, 0.4f);
            gl.Vertex(0.8f, 0.0f, 0.4f);
            gl.Vertex(0.8f, 0.0f, -0.4f);
            gl.Vertex(1.8f, 0.0f, -0.4f);

            // Bottom
            gl.Vertex(1.8f, -0.4f, 0.4f);
            gl.Vertex(0.8f, -0.4f, 0.4f);
            gl.Vertex(0.8f, -0.4f, -0.4f);
            gl.Vertex(1.8f, -0.4f, -0.4f);


            gl.Color(0.1f, 0.1f, 0.1f);
            
            //////////////////left front wheel
            // Front
            gl.Vertex(-0.6f, -0.6f, 0.42f);
            gl.Vertex(-1.0f, -0.6f, 0.42f);
            gl.Vertex(-1.0f, -0.2f, 0.42f);
            gl.Vertex(-0.6f, -0.2f, 0.42f);
            

            // Back
            gl.Vertex(-0.6f, -0.6f, 0.35f);
            gl.Vertex(-1.0f, -0.6f, 0.35f);
            gl.Vertex(-1.0f, -0.2f, 0.35f);
            gl.Vertex(-0.6f, -0.2f, 0.35f);
            

            // Left
            gl.Vertex(-1.0f, -0.6f, 0.42f);
            gl.Vertex(-1.0f, -0.2f, 0.42f);
            gl.Vertex(-1.0f, -0.2f, 0.35f);
            gl.Vertex(-1.0f, -0.6f, 0.35f);
            

            // Right
            gl.Vertex(-0.6f, -0.6f, 0.42f);
            gl.Vertex(-0.6f, -0.2f, 0.42f);
            gl.Vertex(-0.6f, -0.2f, 0.35f);
            gl.Vertex(-0.6f, -0.6f, 0.35f);

            
            // Top
            gl.Vertex(-0.6f, -0.2f, 0.42f);
            gl.Vertex(-1.0f, -0.2f, 0.42f);
            gl.Vertex(-1.0f, -0.2f, 0.35f);
            gl.Vertex(-0.6f, -0.2f, 0.35f);

            // Bottom
            gl.Vertex(-0.6f, -0.6f, 0.42f);
            gl.Vertex(-1.0f, -0.6f, 0.42f);
            gl.Vertex(-1.0f, -0.6f, 0.35f);
            gl.Vertex(-0.6f, -0.6f, 0.35f);


            //////////////////left back wheel
            // Front
            gl.Vertex(-0.6f, -0.6f, -0.42f);
            gl.Vertex(-1.0f, -0.6f, -0.42f);
            gl.Vertex(-1.0f, -0.2f, -0.42f);
            gl.Vertex(-0.6f, -0.2f, -0.42f);
            

            // Back
            gl.Vertex(-0.6f, -0.6f, -0.35f);
            gl.Vertex(-1.0f, -0.6f, -0.35f);
            gl.Vertex(-1.0f, -0.2f, -0.35f);
            gl.Vertex(-0.6f, -0.2f, -0.35f);
            

            // Left
            gl.Vertex(-1.0f, -0.6f, -0.42f);
            gl.Vertex(-1.0f, -0.2f, -0.42f);
            gl.Vertex(-1.0f, -0.2f, -0.35f);
            gl.Vertex(-1.0f, -0.6f, -0.35f);
            

            // Right
            gl.Vertex(-0.6f, -0.6f, -0.42f);
            gl.Vertex(-0.6f, -0.2f, -0.42f);
            gl.Vertex(-0.6f, -0.2f, -0.35f);
            gl.Vertex(-0.6f, -0.6f, -0.35f);

            
            // Top
            gl.Vertex(-0.6f, -0.2f, -0.42f);
            gl.Vertex(-1.0f, -0.2f, -0.42f);
            gl.Vertex(-1.0f, -0.2f, -0.35f);
            gl.Vertex(-0.6f, -0.2f, -0.35f);

            // Bottom
            gl.Vertex(-0.6f, -0.6f, -0.42f);
            gl.Vertex(-1.0f, -0.6f, -0.42f);
            gl.Vertex(-1.0f, -0.6f, -0.35f);
            gl.Vertex(-0.6f, -0.6f, -0.35f);


            //////////////////right front wheel
            // Front
            gl.Vertex(1.5f, -0.6f, 0.42f);
            gl.Vertex(1.1f, -0.6f, 0.42f);
            gl.Vertex(1.1f, -0.2f, 0.42f);
            gl.Vertex(1.5f, -0.2f, 0.42f);
            

            // Back
            gl.Vertex(1.5f, -0.6f, 0.35f);
            gl.Vertex(1.1f, -0.6f, 0.35f);
            gl.Vertex(1.1f, -0.2f, 0.35f);
            gl.Vertex(1.5f, -0.2f, 0.35f);
            

            // Left
            gl.Vertex(1.1f, -0.6f, 0.42f);
            gl.Vertex(1.1f, -0.2f, 0.42f);
            gl.Vertex(1.1f, -0.2f, 0.35f);
            gl.Vertex(1.1f, -0.6f, 0.35f);
            

            // Right
            gl.Vertex(1.5f, -0.6f, 0.42f);
            gl.Vertex(1.5f, -0.2f, 0.42f);
            gl.Vertex(1.5f, -0.2f, 0.35f);
            gl.Vertex(1.5f, -0.6f, 0.35f);

            
            // Top
            gl.Vertex(1.5f, -0.2f, 0.42f);
            gl.Vertex(1.1f, -0.2f, 0.42f);
            gl.Vertex(1.1f, -0.2f, 0.35f);
            gl.Vertex(1.5f, -0.2f, 0.35f);

            // Bottom
            gl.Vertex(1.5f, -0.6f, 0.42f);
            gl.Vertex(1.1f, -0.6f, 0.42f);
            gl.Vertex(1.1f, -0.6f, 0.35f);
            gl.Vertex(1.5f, -0.6f, 0.35f);


            //////////////////right back wheel
            // Front
            gl.Vertex(1.5f, -0.6f, -0.42f);
            gl.Vertex(1.1f, -0.6f, -0.42f);
            gl.Vertex(1.1f, -0.2f, -0.42f);
            gl.Vertex(1.5f, -0.2f, -0.42f);
            

            // Back
            gl.Vertex(1.5f, -0.6f, -0.35f);
            gl.Vertex(1.1f, -0.6f, -0.35f);
            gl.Vertex(1.1f, -0.2f, -0.35f);
            gl.Vertex(1.5f, -0.2f, -0.35f);
            

            // Left
            gl.Vertex(1.1f, -0.6f, -0.42f);
            gl.Vertex(1.1f, -0.2f, -0.42f);
            gl.Vertex(1.1f, -0.2f, -0.35f);
            gl.Vertex(1.1f, -0.6f, -0.35f);
            

            // Right
            gl.Vertex(1.5f, -0.6f, -0.42f);
            gl.Vertex(1.5f, -0.2f, -0.42f);
            gl.Vertex(1.5f, -0.2f, -0.35f);
            gl.Vertex(1.5f, -0.6f, -0.35f);

            
            // Top
            gl.Vertex(1.5f, -0.2f, -0.42f);
            gl.Vertex(1.1f, -0.2f, -0.42f);
            gl.Vertex(1.1f, -0.2f, -0.35f);
            gl.Vertex(1.5f, -0.2f, -0.35f);

            // Bottom
            gl.Vertex(1.5f, -0.6f, -0.42f);
            gl.Vertex(1.1f, -0.6f, -0.42f);
            gl.Vertex(1.1f, -0.6f, -0.35f);
            gl.Vertex(1.5f, -0.6f, -0.35f);

            gl.End();
       
            // Контроль полной отрисовки следующего изображения
            gl.Flush();

            // Меняем угол поворота 
            rtri -= 3.0f;
            rquad -= 15.0f;

        }
    }
}