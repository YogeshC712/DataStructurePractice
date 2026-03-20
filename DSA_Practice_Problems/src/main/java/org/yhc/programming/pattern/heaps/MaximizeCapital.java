package org.yhc.programming.pattern.heaps;

/*
A busy investor with an initial capital, c, needs an automated investment program. They can select k distinct projects from a list of n projects with corresponding capitals requirements and expected profits. For a given project
i, its capital requirement is capitals[i], and the profit it yields is profits[i].

The goal is to maximize their cumulative capital by selecting a maximum of k distinct projects to invest in, subject to the constraint that the investor’s current capital must be greater than or equal to the capital requirement of all selected projects.

When a selected project from the identified ones is finished, the pure profit from the project, along with the starting capital of that project is returned to the investor. This amount will be added to the total capital held by the investor.
Now, the investor can invest in more projects with the new total capital. It is important to note that each project can only be invested once.

As a basic risk-mitigation measure, the investor wants to limit the number of projects they invest in. For example, if k is 2, the program should identify the two projects that maximize the investor’s profits while ensuring that the investor’s capital is sufficient to invest in the projects.

Overall, the program should help the investor to make informed investment decisions by picking a list of a maximum of k distinct projects to maximize the final profit while mitigating the risk.
 */

import java.util.PriorityQueue;

//Solution Approach
/*
This approach optimizes the selection of projects to maximize capital using a two-heap method. By pushing projects’ capital into a min-heap, projects are organized in ascending order of capital needed.
Then, we choose projects from the min-heap that fit within our available capital, prioritizing those with the lowest costs. The selected projects are evaluated for their profitability by inserting their profits into a max-heap.
This allows for prioritizing projects based on their potential return on investment. The most profitable project from the max-heap is chosen, and its profit is added to the current capital.
The selected project is excluded from the list of available projects, and the same steps are repeated with the updated capital to select the next project.
This process—selecting projects based on the capital requirement, evaluating project affordability, selecting for maximum profit, and updating available capital—is repeated for k times to select k projects that yield maximum profit.
 */
public class MaximizeCapital {
    public static void main(String[] args) {
        int c = 1;
        int k = 2;
        int[] capitals = {1, 2, 2, 3};
        int[] profits = {2, 4, 6, 8};
        
        maximizeCapital(c, k, capitals, profits);
    }

    private static void maximizeCapital(int c, int k, int[] capitals, int[] profits) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        while (i < capitals.length){
            minHeap.add(capitals[i]);
            i++;
        }
    }
}
