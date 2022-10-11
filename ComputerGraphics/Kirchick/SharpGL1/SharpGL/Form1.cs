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


            //////////////КУБИК
           
            gl.LoadIdentity();
            gl.Translate(0.0f, -1f, -4.5f);
            gl.Rotate(rquad, 0.0f, 1.0f, 0.0f);
                  
            gl.Color(1.0f, 0.0f, 0.0f, 0.0f);
            gl.Begin(OpenGL.GL_QUADS);
            
            //////////////////Big box
            // Bottom
            gl.Vertex(1.0f, 0.0f, 0.4f);
            gl.Vertex(-1.0f, 0.0f, 0.4f);
            gl.Vertex(-1.0f, 0f, -0.4f);
            gl.Vertex(1.0f, 0.0f, -0.4f);
            
            // Front
            gl.Vertex(1.0f, 0.0f, 0.4f);
            gl.Vertex(-1.0f, 0.0f, 0.4f);
            gl.Vertex(-1.0f, 0.8f, 0.4f);
            gl.Vertex(1.0f, 0.8f, 0.4f);
            
            
            // Back
            gl.Vertex(1.0f, 0.0f, -0.4f);
            gl.Vertex(-1.0f, 0.0f, -0.4f);
            gl.Vertex(-1.0f, 0.8f, -0.4f);
            gl.Vertex(1.0f, 0.8f, -0.4f);
            
            
            // Left
            gl.Vertex(-1.0f, 0.0f, 0.4f);
            gl.Vertex(-1.0f, 0.8f, 0.4f);
            gl.Vertex(-1.0f, 0.8f, -0.4f);
            gl.Vertex(-1.0f, 0.0f, -0.4f);
            
           
            // Right
            gl.Vertex(1.0f, 0.0f, 0.4f);
            gl.Vertex(1.0f, 0.8f, 0.4f);
            gl.Vertex(1.0f, 0.8f, -0.4f);
            gl.Vertex(1.0f, 0.0f, -0.4f);

           
            // Top
            gl.Vertex(1.0f, 0.8f, 0.4f);
            gl.Vertex(-1.0f, 0.8f, 0.4f);
            gl.Vertex(-1.0f, 0.8f, -0.4f);
            gl.Vertex(1.0f, 0.8f, -0.4f);

            ///////////////////////Small box
            gl.Color(1.0f, 1.0f, 1.0f, 0.0f);
            
            // Front
            gl.Vertex(1.5f, 0.0f, 0.38f);
            gl.Vertex(1.001f, 0.0f, 0.38f);
            gl.Vertex(1.001f, 0.7f, 0.38f);
            gl.Vertex(1.5f, 0.7f, 0.38f);
            

            // Back
            gl.Vertex(1.5f, 0.0f, -0.38f);
            gl.Vertex(1.001f, 0.0f, -0.38f);
            gl.Vertex(1.001f, 0.7f, -0.38f);
            gl.Vertex(1.5f, 0.7f, -0.38f);
            
            
            // Right
            gl.Vertex(1.5f, 0.0f, 0.38f);
            gl.Vertex(1.5f, 0.7f, 0.38f);
            gl.Vertex(1.5f, 0.7f, -0.38f);
            gl.Vertex(1.5f, 0.0f, -0.38f);

           
            // Top
            gl.Vertex(1.5f, 0.7f, 0.38f);
            gl.Vertex(1.001f, 0.7f, 0.38f);
            gl.Vertex(1.001f, 0.7f, -0.38f);
            gl.Vertex(1.5f, 0.7f, -0.38f);


            gl.Color(0.1f, 0.1f, 0.1f);

            /////////////////////Left front wheel
            // Front
            gl.Vertex(-0.65f, -0.1f, 0.42f);
            gl.Vertex(-0.85f, -0.1f, 0.42f);
            gl.Vertex(-0.85f, 0.1f, 0.42f);
            gl.Vertex(-0.65f, 0.1f, 0.42f);


            // Back
            gl.Vertex(-0.65f, -0.1f, 0.35f);
            gl.Vertex(-0.85f, -0.1f, 0.35f);
            gl.Vertex(-0.85f, 0.1f, 0.35f);
            gl.Vertex(-0.65f, 0.1f, 0.35f);


            // Left
            gl.Vertex(-0.85f, -0.1f, 0.42f);
            gl.Vertex(-0.85f, 0.1f, 0.42f);
            gl.Vertex(-0.85f, 0.1f, 0.35f);
            gl.Vertex(-0.85f, -0.1f, 0.35f);


            // Right
            gl.Vertex(-0.65f, -0.1f, 0.42f);
            gl.Vertex(-0.65f, 0.1f, 0.42f);
            gl.Vertex(-0.65f, 0.1f, 0.35f);
            gl.Vertex(-0.65f, -0.1f, 0.35f);


            // Top
            gl.Vertex(-0.85f, 0.1f, 0.42f);
            gl.Vertex(-0.85f, 0.1f, 0.35f);
            gl.Vertex(-0.65f, 0.1f, 0.35f);
            gl.Vertex(-0.65f, 0.1f, 0.42f);


            // Bottom
            gl.Vertex(-0.85f, -0.1f, 0.42f);
            gl.Vertex(-0.85f, -0.1f, 0.35f);
            gl.Vertex(-0.65f, -0.1f, 0.35f);
            gl.Vertex(-0.65f, -0.1f, 0.42f);



            //////////////////////Middle front wheel
            // Front
            gl.Vertex(-0.15f, -0.1f, 0.42f);
            gl.Vertex(-0.35f, -0.1f, 0.42f);
            gl.Vertex(-0.35f, 0.1f, 0.42f);
            gl.Vertex(-0.15f, 0.1f, 0.42f);


            // Back
            gl.Vertex(-0.15f, -0.1f, 0.35f);
            gl.Vertex(-0.35f, -0.1f, 0.35f);
            gl.Vertex(-0.35f, 0.1f, 0.35f);
            gl.Vertex(-0.15f, 0.1f, 0.35f);


            // Left
            gl.Vertex(-0.35f, -0.1f, 0.42f);
            gl.Vertex(-0.35f, 0.1f, 0.42f);
            gl.Vertex(-0.35f, 0.1f, 0.35f);
            gl.Vertex(-0.35f, -0.1f, 0.35f);


            // Right
            gl.Vertex(-0.15f, -0.1f, 0.42f);
            gl.Vertex(-0.15f, 0.1f, 0.42f);
            gl.Vertex(-0.15f, 0.1f, 0.35f);
            gl.Vertex(-0.15f, -0.1f, 0.35f);


            // Top
            gl.Vertex(-0.35f, 0.1f, 0.42f);
            gl.Vertex(-0.35f, 0.1f, 0.35f);
            gl.Vertex(-0.15f, 0.1f, 0.35f);
            gl.Vertex(-0.15f, 0.1f, 0.42f);


            // Bottom
            gl.Vertex(-0.35f, -0.1f, 0.42f);
            gl.Vertex(-0.35f, -0.1f, 0.35f);
            gl.Vertex(-0.15f, -0.1f, 0.35f);
            gl.Vertex(-0.15f, -0.1f, 0.42f);


            //////////////////////Right front wheel
            // Front
            gl.Vertex(1.15f, -0.1f, 0.42f);
            gl.Vertex(1.35f, -0.1f, 0.42f);
            gl.Vertex(1.35f, 0.1f, 0.42f);
            gl.Vertex(1.15f, 0.1f, 0.42f);


            // Back
            gl.Vertex(1.15f, -0.1f, 0.35f);
            gl.Vertex(1.35f, -0.1f, 0.35f);
            gl.Vertex(1.35f, 0.1f, 0.35f);
            gl.Vertex(1.15f, 0.1f, 0.35f);


            // Left
            gl.Vertex(1.35f, -0.1f, 0.42f);
            gl.Vertex(1.35f, 0.1f, 0.42f);
            gl.Vertex(1.35f, 0.1f, 0.35f);
            gl.Vertex(1.35f, -0.1f, 0.35f);


            // Right
            gl.Vertex(1.15f, -0.1f, 0.42f);
            gl.Vertex(1.15f, 0.1f, 0.42f);
            gl.Vertex(1.15f, 0.1f, 0.35f);
            gl.Vertex(1.15f, -0.1f, 0.35f);


            // Top
            gl.Vertex(1.35f, 0.1f, 0.42f);
            gl.Vertex(1.35f, 0.1f, 0.35f);
            gl.Vertex(1.15f, 0.1f, 0.35f);
            gl.Vertex(1.15f, 0.1f, 0.42f);


            // Bottom
            gl.Vertex(1.35f, -0.1f, 0.42f);
            gl.Vertex(1.35f, -0.1f, 0.35f);
            gl.Vertex(1.15f, -0.1f, 0.35f);
            gl.Vertex(1.15f, -0.1f, 0.42f);



            /////////////////////Left back wheel
            // Front
            gl.Vertex(-0.65f, -0.1f, -0.42f);
            gl.Vertex(-0.85f, -0.1f, -0.42f);
            gl.Vertex(-0.85f, 0.1f, -0.42f);
            gl.Vertex(-0.65f, 0.1f, -0.42f);


            // Back
            gl.Vertex(-0.65f, -0.1f, -0.35f);
            gl.Vertex(-0.85f, -0.1f, -0.35f);
            gl.Vertex(-0.85f, 0.1f, -0.35f);
            gl.Vertex(-0.65f, 0.1f, -0.35f);


            // Left
            gl.Vertex(-0.85f, -0.1f, -0.42f);
            gl.Vertex(-0.85f, 0.1f, -0.42f);
            gl.Vertex(-0.85f, 0.1f, -0.35f);
            gl.Vertex(-0.85f, -0.1f, -0.35f);


            // Right
            gl.Vertex(-0.65f, -0.1f, -0.42f);
            gl.Vertex(-0.65f, 0.1f, -0.42f);
            gl.Vertex(-0.65f, 0.1f, -0.35f);
            gl.Vertex(-0.65f, -0.1f, -0.35f);


            // Top
            gl.Vertex(-0.85f, 0.1f, -0.42f);
            gl.Vertex(-0.85f, 0.1f, -0.35f);
            gl.Vertex(-0.65f, 0.1f, -0.35f);
            gl.Vertex(-0.65f, 0.1f, -0.42f);


            // Bottom
            gl.Vertex(-0.85f, -0.1f, -0.42f);
            gl.Vertex(-0.85f, -0.1f, -0.35f);
            gl.Vertex(-0.65f, -0.1f, -0.35f);
            gl.Vertex(-0.65f, -0.1f, -0.42f);


            //////////////////////Middle back wheel
            // Front
            gl.Vertex(-0.15f, -0.1f, -0.42f);
            gl.Vertex(-0.35f, -0.1f, -0.42f);
            gl.Vertex(-0.35f, 0.1f, -0.42f);
            gl.Vertex(-0.15f, 0.1f, -0.42f);


            // Back
            gl.Vertex(-0.15f, -0.1f, -0.35f);
            gl.Vertex(-0.35f, -0.1f, -0.35f);
            gl.Vertex(-0.35f, 0.1f, -0.35f);
            gl.Vertex(-0.15f, 0.1f, -0.35f);


            // Left
            gl.Vertex(-0.35f, -0.1f, -0.42f);
            gl.Vertex(-0.35f, 0.1f, -0.42f);
            gl.Vertex(-0.35f, 0.1f, -0.35f);
            gl.Vertex(-0.35f, -0.1f, -0.35f);


            // Right
            gl.Vertex(-0.15f, -0.1f, -0.42f);
            gl.Vertex(-0.15f, 0.1f, -0.42f);
            gl.Vertex(-0.15f, 0.1f, -0.35f);
            gl.Vertex(-0.15f, -0.1f, -0.35f);


            // Top
            gl.Vertex(-0.35f, 0.1f, -0.42f);
            gl.Vertex(-0.35f, 0.1f, -0.35f);
            gl.Vertex(-0.15f, 0.1f, -0.35f);
            gl.Vertex(-0.15f, 0.1f, -0.42f);


            // Bottom
            gl.Vertex(-0.35f, -0.1f, -0.42f);
            gl.Vertex(-0.35f, -0.1f, -0.35f);
            gl.Vertex(-0.15f, -0.1f, -0.35f);
            gl.Vertex(-0.15f, -0.1f, -0.42f);


            //////////////////////Right back wheel
            // Front
            gl.Vertex(1.15f, -0.1f, -0.42f);
            gl.Vertex(1.35f, -0.1f, -0.42f);
            gl.Vertex(1.35f, 0.1f, -0.42f);
            gl.Vertex(1.15f, 0.1f, -0.42f);


            // Back
            gl.Vertex(1.15f, -0.1f, -0.35f);
            gl.Vertex(1.35f, -0.1f, -0.35f);
            gl.Vertex(1.35f, 0.1f, -0.35f);
            gl.Vertex(1.15f, 0.1f, -0.35f);


            // Left
            gl.Vertex(1.35f, -0.1f, -0.42f);
            gl.Vertex(1.35f, 0.1f, -0.42f);
            gl.Vertex(1.35f, 0.1f, -0.35f);
            gl.Vertex(1.35f, -0.1f, -0.35f);


            // Right
            gl.Vertex(1.15f, -0.1f, -0.42f);
            gl.Vertex(1.15f, 0.1f, -0.42f);
            gl.Vertex(1.15f, 0.1f, -0.35f);
            gl.Vertex(1.15f, -0.1f, -0.35f);


            // Top
            gl.Vertex(1.35f, 0.1f, -0.42f);
            gl.Vertex(1.35f, 0.1f, -0.35f);
            gl.Vertex(1.15f, 0.1f, -0.35f);
            gl.Vertex(1.15f, 0.1f, -0.42f);


            // Bottom
            gl.Vertex(1.35f, -0.1f, -0.42f);
            gl.Vertex(1.35f, -0.1f, -0.35f);
            gl.Vertex(1.15f, -0.1f, -0.35f);
            gl.Vertex(1.15f, -0.1f, -0.42f);

            gl.End();
       
            // Контроль полной отрисовки следующего изображения
            gl.Flush();

            // Меняем угол поворота 
            rtri -= 3.0f;
            rquad -= 3.0f;

        }
    }
}