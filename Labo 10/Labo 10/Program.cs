using System;
using System.Collections.Generic;
using System.Linq;

namespace Labo_10
{
    internal class Program
    {
        private delegate void explicitDelegate(List<CuentaBancaria> Accounts);

        private static explicitDelegate UsingExplicitDelegate;

        public static void Main(string[] args)
        {
            #region Delegate explicito
            UsingExplicitDelegate = ViewAccounts; 
            UsingExplicitDelegate += TotalCurrentBalances;
            #endregion
            
            #region Usando action
            Action<List<CuentaBancaria>> UsingAction = (Account) =>
            {
                Account.ForEach((acct) =>
                {
                    Console.WriteLine($"Nombre: {acct.name}, Sueldo actual: ${acct.currentBalance}");
                });
            };
            UsingAction += (Accts) =>
            {
                double total = 0;

                Accts.ForEach(acct =>
                {
                    total += acct.currentBalance;
                });

                Console.WriteLine($"Total de cuentas: ${total}");
            };
            UsingAction += (Accts) =>
            {
                Console.WriteLine("Cuentas de personas cuyo nombre empieza por una vocal: ");
                bool isVowel;
                Accts.ForEach((acct) =>
                {
                    isVowel = "aeiouAEIOU".IndexOf(acct.name[0]) >= 0;
                    if (isVowel)
                        Console.WriteLine($"Nombre: {acct.name}, Sueldo actual: ${acct.currentBalance}");
                });
            };
            #endregion

            var Accounts = new List<CuentaBancaria>();
            byte option = 0;
            while (option != 5)
            {
                try
                {
                    Console.Write("");
                    MainMenu();
                    option = Convert.ToByte(Console.ReadLine());
                    if (option < 1 || option > 5)
                        throw new ArgumentOutOfRangeException();
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                }

                switch (option)
                {
                    case 1:
                        AddAccount(Accounts);
                        break;
                    case 2:
                        ViewAccounts(Accounts);
                        break;
                    case 3:
                        UsingExplicitDelegate.Invoke(Accounts);
                        break;
                    case 4:
                        UsingAction(Accounts);
                        break;
                    case 5:
                        break;
                }
            }
        }

        public static void MainMenu()
        {
            Console.Write("-------------------------------------------\n MENU PRINCIPAL \n(1) Agregar cuenta" +
                          "\n(2) Ver cuentas almacenadas" +
                          "\n(3) Ver cuentas almacenadas y total de cuentas "+
                          "\n(4) Ver cuentas almacenadas, total de cuentas y cuentas de las personas cuyo nombre inicie "+
                          "con una vocal \n(5) Salir \nOPCION:");
        }
        
        public static void AddAccount(List<CuentaBancaria> Accounts)
        {
            string name = null;
            double currentBalance = 0;
            bool loop = true;
            
            while (loop)
            {
                try
                {
                    loop = false;
                    Console.Write("Nombre:");
                    name = Console.ReadLine();
                    if (string.IsNullOrEmpty(name))
                        throw new ArgumentNullException();
                    Console.Write("Saldo actual: ");
                    currentBalance = Convert.ToDouble(Console.ReadLine());
                }
                catch (Exception e)
                {
                    loop = true;
                    Console.WriteLine(e);
                }
            }
            Accounts.Add(new CuentaBancaria(name, currentBalance));
        }
        
        public static void ViewAccounts(List<CuentaBancaria> Accounts)
        {
            Accounts.ForEach((acct) =>
            {
                Console.WriteLine($"Nombre: {acct.name}, Saldo actual: ${acct.currentBalance}");
            });
        }
        
        public static void TotalCurrentBalances(List<CuentaBancaria> Accounts)
        {
            double total = 0;

            Accounts.ForEach(acct =>
            {
                total += acct.currentBalance;
            });

            Console.WriteLine($"Total de cuentas: ${total}");
        }
    }
}