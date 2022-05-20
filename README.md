# DDROIDD-Internship
Please organize, design, test, and document your code to the best of your ability.

Challenge Description
Write a program that that will compute the totals for a shopping cart of products shipped from different countries, apply various offers and finally display a total detailed invoice in USD as well.

You are given a static (pre-defined) catalog of products. The customer can select multiple items from the catalog of products to add to the shopping cart. Once the shopping cart is ready for checkout, an invoice will be generated containing all details.

Available catalog of products with their respective price in USD (this does not include shipping): Hint: see below, how to calculate each item shipping fees

Item name	Item price	Shipped from	Weight
Mouse	$10.99	RO	0.2kg
Keyboard	$40.99	UK	0.7kg
Monitor	$164.99	US	1.9kg
Webcam	$84.99	RO	0.2kg
Headphones	$59.99	US	0.6kg
Desk Lamp	$89.99	UK	1.3kg
The products are shipped from 3 different countries: RO, UK, US. Shipping fees apply based on the country where the item is shipped from and the shipping rate is per 0.1kg. You can find the shipping rates below

Shipping rates: Hint: see below, how to calculate each item shipping fees

Country	Rate
RO	$1
UK	$2
US	$3
##Mandatory Requirements

Start your challenge as a Console Application and do the following:

Build the data model (classes) that best fits the description above (e.g. Products, ShippingRate).
Using the classes defined, create a data structure with the information in the provided catalog of products and the shipping rates
Display to the console the catalog of products (product name and price) by reading from the data structure. Expected output
Mouse - $10.99
Keyboard - $40.99
Monitor - $164.99
Webcam - $84.99
Headphones - $59.99
Desk Lamp - $89.99
Allow the customer to select a list of products. A product can be selected multiple times. Display the contents of the shopping cart after each insertion. Sample Interaction:

Input	Output
Mouse	Mouse x 1
Monitor	Mouse x 1
Monitor x 1
Monitor	Mouse x 1
Monitor x 2
Allow the customer to proceed to checkout. This will generate the detailed invoice. Here are some examples:

Shopping cart contents	Invoice
Mouse x 1
Monitor x 2	Subtotal: $340.97
Shipping: $116
Total: $456.97
Monitor x1	Subtotal: $164.99
Shipping: $57
Total: $221.99
Write Unit Tests to make sure you're computing the correct totals

Write a Readme document for your repository describing your solution and how to run it

##Optional (extra points) requirements

Add the special offers functionality to the program. These offers will affect the way pricing is made. This is the predefined list of offers. These offers can be applied simultaneously.
Keyboards are 10% off
Buy 2 Monitors and get a desk lamp at half price
Buy any 2 items or more and get a maximum of $10 off shipping fees
Add the discounts to the invoice - each discount with the its subtotal Here are some examples:
Shopping cart contents	Invoice
Keyboard x 1
Monitor x 2	Subtotal: $370.97
Shipping: $128

Discounts:
10% off keyboards: -$4.09
$10 off shipping: -$10

Total: $484.88
Add the VAT functionality. There is a 19% VAT applied to all products (before discounts, and it doesn't apply to the shipping fee), whatever the shipping country is. Also show this functionality in the detailed invoice Here are some examples:
Shopping cart contents	Invoice
Keyboard x 1
Monitor x 2	Subtotal: $370.97
Shipping: $128
VAT: $70.48

Discounts:
10% off keyboards: -$4.09
$10 off shipping: -$10

Total: $555.36
Frequently Asked Questions
####Q: I'm confused at how shipping and VAT is computed. Answer: Take the table below as a reference, but do not hardcode the values in the code. They need to be computed on demand

Item name	Item price	Shipped from	Weight	Shipping Rate	Shipping Cost	VAT
Mouse	$10.99	RO	0.2kg	$1	$2	$2.08
Keyboard	$40.99	UK	0.7kg	$2	$14	$7.78
Monitor	$164.99	US	1.9kg	$3	$57	$31.34
Webcam	$84.99	RO	0.2kg	$1	$2	$16.14
Headphones	$59.99	US	0.6kg	$3	$18	$11.39
Desk Lamp	$89.99	UK	1.3kg	$2	$26	$17.09
####Q: What programming language can I use to write the program? Answer: The internship targets Java and C#. You're free to use any of them

####Q: How much time do I have to complete the task Answer: The deadline for submitting your solution to the problem is 23 May at 22:00

Expected deliverables
Push your code to a public git repository and send that link back to your recruiter. If this option is not applicable to you, create a ZIP archive and attach it to the email you are sending to your recruiter.
The code should be written to the best of your ability (code quality, comments, documentation, formatting, etc.)
If you didn't manage to finish all requirements, just send the project with the state at which it finds it at the deadline!