# Movie-Ticket-Plans
Assignment to develop several components of a system called MovieTix.

Movie Plan - a plan with both pre-paid tickets and the ability to purchase tickets on credit. Any pre-paid tickets that are not used during the semester are lost (and the purchase price is not refunded).
Tiered Plan - a plan with both pre-paid tickets and the ability to purchase tickets on credit. It differs from a Movie Plan in that the first group of "purchases" is at a different price from the subsequent "purchases".
Limited Plan - a plan with both pre-paid tickets and the ability to purchase a limited dollar amount of tickets on credit.


Interval Class: The Interval class is an encapsulation of an interval on the real line. Interval objects are used in several places.

Category Enum: The Category enum encapsulates a predefined set of price categories.

MoviePlan Class: The MoviePlan class encapsulates pre-paid movie plans with a fixed up-front cost and number of tickets, and the ability to purchase "extra" tickets on credit at a pre-determiend cost.

LimitedPlan Class: The LimitedPlan class is a specialization of the MoviePlan class in which there is a limit on the amount of money that can be spent on credit.

TieredPlan Class: The TieredPlan class is a specialization of a MoviePlan in which there is a special initial tier of purchases (at a different price from ordinary purchases).

The PlanUtilities class is a utility class that can be used to perform operations on MoviePlan objects. Must return the least expensive MoviePlan (among those passed to it) based on each plan's current cost-per-movie.


