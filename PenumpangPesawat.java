class Passenger{
    String name;
    Passenger next;

    public Passenger(String name){
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
        System.out.println("Penumpang '" + name + "' telah ditambahkan.");
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang untuk dihapus.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Penumpang '" + name + "' telah dihapus.");
            return;
        }
        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            previous.next = current.next;
            System.out.println("Penumpang '" + name + "' telah dihapus.");
        } else {
            System.out.println("Penumpang '" + name + "' tidak ditemukan.");
        }
    }

    public void displayPassenger() {
        if (head == null) {
            System.out.println("Tidak ada penumpang.");
            return;
        }
        Passenger current = head;
        System.out.println("Daftar penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}

public class PenumpangPesawat {
    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Putri");
        flight.addPassenger("Lala");
        flight.addPassenger("Alice");

        flight.displayPassenger();

        flight.removePassenger("Lala");
        flight.displayPassenger();

        flight.removePassenger("Caca");

        flight.displayPassenger();
    }
}
