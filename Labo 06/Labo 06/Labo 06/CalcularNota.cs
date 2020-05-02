using System;
using System.Collections.Generic;

namespace Labo_06
{
    public static class CalcularNota
    {
        public static double Calcular(List<Evaluacion> listaEvaluaciones)
        {
            Console.WriteLine("Formato de notas: 10.0/10.0");
            double sum = 0.0;
            double nota = 0.0;
            bool loop = true;
            foreach (var evaluacion in listaEvaluaciones)
            {
                loop = true;
                while (loop)
                {
                    try
                    {
                        loop = false;
                        Console.Write("Nota de " + evaluacion.nombre + ": ");
                        nota = Convert.ToDouble(Console.ReadLine());
                        if (nota < 0.0 || nota > 10.0)
                            throw new ArgumentOutOfRangeException();
                    }
                    catch (ArgumentOutOfRangeException e)
                    {
                        Console.WriteLine(e);
                        loop = true;
                    }
                    catch (System.ArgumentException e)
                    {
                        Console.WriteLine(e);
                        loop = true;
                    }
                }
                sum += nota * (evaluacion.porcentaje / 100.0);
            }
            return sum;
        }
    }
}