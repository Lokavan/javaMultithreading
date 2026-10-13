package org.example.design_pat;





    interface PaymentStrategy {
        void pay(double amount);
    }

     class CardPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid by card: " + amount);
        }
    }

     class PayPalPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid by PayPal: " + amount);
        }
    }

     class PaymentService {

        private PaymentStrategy strategy;

        PaymentService(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        void processPayment(double amount) {
            strategy.pay(amount);
        }
    }

     class Main {
        public static void main(String[] args) {

            PaymentService service =
                    new PaymentService(new CardPayment());

            service.processPayment(500);
        }
    }



    /*Strategy Pattern allows us to define multiple algorithms
      behind a common interface and choose the appropriate
      implementation at runtime. It supports loose coupling
      and the Open/Closed Principle.*/