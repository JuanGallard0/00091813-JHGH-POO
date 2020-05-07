using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Labo_07
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            comboBox1.DataSource = new List<string>() { "Morado", "Celeste", "Rosado" };
        }

        private void buttonRed_Click(object sender, EventArgs e)
        {
            BackColor = Color.Red;
        }

        private void buttonBlue_Click(object sender, EventArgs e)
        {
            BackColor = Color.Blue;
        }

        private void buttonGreen_Click(object sender, EventArgs e)
        {
            BackColor = Color.Green;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            BackColor = ColorTranslator.FromHtml("#" + textBox1.Text);
        }

        private void buttonCombo_Click(object sender, EventArgs e)
        {
            switch (comboBox1.SelectedIndex)
            {
                case 0:
                    BackColor = ColorTranslator.FromHtml("#E441F2");
                    break;
                case 1:
                    BackColor = ColorTranslator.FromHtml("#41F2E4");
                    break;
                case 2:
                    BackColor = ColorTranslator.FromHtml("#E8B4D0");
                    break;
            }
        }
    }
}