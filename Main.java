import java.util.Scanner;

public class Main {
    public Node head = null;

    static class Node {
        private final String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNodeAtTheBeginning(String data) {
        Node newNode = new Node(data);
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    public void addNodeAtTheEnd(String data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void deleteFirstNode() {
        this.head = this.head.next;
    }

    public void deleteLastNode() {
        if (this.head == null) {
            return;
        }
        if (this.head.next == null) {
            return;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    public void deleteNodeInIndex(int position) {
        if (this.head == null) {
            System.out.println("List Kosong.\n");
            return;
        }
        Node cur = this.head;
        if (position == 0) {
            this.head = cur.next;
            return;
        }
        for (int i = 0; cur != null && i < position - 1; i++) {
            cur = cur.next;
        }
        if (cur == null || cur.next == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    public void display() {
        if (this.head == null) {
            System.out.println("List Kosong.");
        } else {
            System.out.println("Isi Linked List : ");
            Node cur = this.head;
            while (cur != null) {
                System.out.print(cur.data + " -> ");
                cur = cur.next;
            }
            System.out.print("NULL\n");
        }
    }

    public static void menu() {
        System.out.println("Aplikasi Daftar Surat");
        System.out.print("1. Tambah Surat Di Awal Posisi\n2. Tambah Surat Di Akhir\n3. Hapus Surat Pertama\n4. Hapus Surat Terakhir,\n5. Hapus Surat Berdasarkan Index\n6. Berhenti\n");
        System.out.print("Silahkan Pilih Menu : ");
    }

    public static void main(String[] args) {
        boolean run = true;
        Main list = new Main();
        Scanner input = new Scanner(System.in);
        while (run) {
            System.out.println(" ");
            list.display();
            System.out.println(" ");
            menu();
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Surat : ");
                    String namaSurat = input.next();
                    try {
                        list.addNodeAtTheBeginning(namaSurat);
                    } catch (Exception e) {
                        System.out.println("Ada Sesuatu Yang ");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan Nama Surat : ");
                    String suratTerakhir = input.next();
                    try {
                        list.addNodeAtTheEnd(suratTerakhir);
                    } catch (Exception e) {
                        System.out.println("Ada Sesuatu Yang Salah ");
                    }
                    break;
                case 3:
                    list.deleteFirstNode();
                    break;
                case 4:
                    list.deleteLastNode();
                    break;
                case 5:
                    System.out.print("Masukkan Index Surat : ");
                    int hapusSurat = input.nextInt();
                    try {
                        list.deleteNodeInIndex(hapusSurat);
                    } catch (Exception e) {
                        System.out.println("Ada Sesuatu Yang Salah ");
                    }
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Mohon Masukkan INputan Yang sesuai");
                    break;
            }
        }

    }
}