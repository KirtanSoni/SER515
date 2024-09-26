package org.SER.classes;

public class BacklogManagementSystem {

    private final SprintBacklog sprintBacklog;
    private final ProductBacklog productBacklog;

    public BacklogManagementSystem(SprintBacklog sprintBacklog, ProductBacklog productBacklog) {
        this.sprintBacklog = sprintBacklog;
        this.productBacklog = productBacklog;
    }

    public void manageBacklog(User user, UserStory userStory) {
        UserType userType = user.getUserType();

        if (userType == UserType.DEVELOPER) {
            // Developer can view and update Sprint Backlog
            System.out.println("Developer Access:");
            System.out.println("Sprint Backlog: " + sprintBacklog.getsprintBacklog());

            // Example: Update status of a User Story in Sprint Backlog
            int userStoryIdToUpdate = userStory.getId();
            Status newStatus = Status.IN_PROGRESS;
            sprintBacklog.updateStatus(userStoryIdToUpdate, newStatus);

            // Example: Remove a User Story from Sprint Backlog
            int userStoryIdToRemove = userStory.getId();
            sprintBacklog.removeUserStory(userStoryIdToRemove);

            // You can add more functionality specific to developers here
        } else if (userType == UserType.PRODUCT_OWNER) {
            // Product Owner can view and update Product Backlog
            System.out.println("Product Owner Access:");
            // System.out.println("Product Backlog: " + productBacklog.getProductBacklog());

            // Example: Update priority of a User Story in Product Backlog
            // add priority params if required
            // int userStoryIdToUpdate = userStory.getId();
            // int newPriority = priority;
            // productBacklog.updatePriority(userStoryIdToUpdate, newPriority);

            // Example: Remove a User Story from Product Backlog
            int userStoryIdToRemove = userStory.getId(); // Replace with the actual User Story ID
            productBacklog.removeUserStory(userStoryIdToRemove);

            // You can add more functionality specific to product owners here
        } else {
            // Handle other user types or provide a default behavior
            System.out.println("Invalid user type or access not granted.");
        }
    }
}
