namespace Labo_06
{
    public class Laboratorio : Evaluacion
    {
        private string tipo;

        public Laboratorio(int porcentaje, string nombre, string tipo) : base(porcentaje, nombre)
        {
            this.tipo = tipo;
        }

        public override string ToString()
        {
            return $"Laboratorio = {base.ToString()}, {nameof(tipo)}: {tipo}";
        }
    }
}