package homework1.src;

import java.util.ArrayList;
import java.util.List;

public class TicketProcessorArray {
    public static void main(String[] args) {
        processTicketsLinkedList();

    }

    public static void processTicketsLinkedList() {

        ArrayList<String> ticketQueue = new ArrayList<>();

        // Uncomment the queue length you want to test with
        //createShortQueue(ticketQueue);
        createLongQueue(ticketQueue);

        long start = System.nanoTime(); // start testing runtime

        int next = 0;

        while (next < ticketQueue.size()) {
            // grab the first item in the list
            //String currentTicket = ticketQueue.remove(0);

            //create a pointer that points to the next item in the queue; not deleting anything until the end
            String currentTicket = ticketQueue.get(next);
            next++;


            System.out.println("Processing: " + currentTicket);

            System.out.println("Finished! Remaining in line: " + ticketQueue.size());
            System.out.println("---------------------------");
        }

        ticketQueue.clear();

        long end = System.nanoTime(); // end testing runtime

        System.out.println("Run time was " + (end - start) / 1000000.0 + " milliseconds." ); // print runtime
    }

    public static void createShortQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 50; i++) {
            queue.add("Ticket #" + i);
        }
    }

    public static void createLongQueue(List<String> queue) {
        // feel free to change the number of tickets here to test different queue sizes
        for (int i = 1; i <= 20000; i++) {
            queue.add("Ticket #" + i);
        }
    }

}
