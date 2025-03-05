package com.sudagoarth.events.Ticket.DataTransferObjects.Ticket;

import jakarta.validation.constraints.NotBlank;

public class TicketRequest {

    @NotBlank(message = "Event ID is required")
    private Long eventId;

    @NotBlank(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Ticket quantity is required")
    private int ticketQuantity;

    @NotBlank(message = "Ticket price is required")
    private double ticketPrice;

    @NotBlank(message = "Ticket status is required")
    private String ticketStatus;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
