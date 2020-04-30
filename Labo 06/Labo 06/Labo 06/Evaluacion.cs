namespace Labo_06
{
    public abstract class Evaluacion
    {
        protected internal int porcentaje { get; }
        protected internal string nombre { get; }

        public Evaluacion(int porcentaje, string nombre)
        {
            this.porcentaje = porcentaje;
            this.nombre = nombre;
        }

        public override string ToString()
        {
            return $"{nameof(porcentaje)}: {porcentaje}, {nameof(nombre)}: {nombre}";
        }
    }
    
}