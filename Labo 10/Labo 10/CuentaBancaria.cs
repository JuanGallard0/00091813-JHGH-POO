namespace Labo_10
{
    public class CuentaBancaria
    {
        public readonly string name;
        public readonly double currentBalance;

        public CuentaBancaria(string name = "unnamed", double currentBalance = 0)
        {
            this.name = name;
            this.currentBalance = currentBalance;
        }
    }
}