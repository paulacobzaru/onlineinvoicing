# onlineinvoicing

This is my Java final project for SDA, with the theme of invoicing online for companies, from different countries. 
It will be developed in IntelliJ, using Spring and Thymeleaf frameworks. The database will be written in SQL WOrkbench. 
The invoices will be generated by a company that sells the on-line app to its companies'clients. 
Each client becomes a different user and can customise its own features in the app, with its own data (the user data become the company supplier data), 
the clients, the products and services provided, the currency used and VAT rates used in the user's country. The project will have different tasks, such as:

- Management of users with different roles;
- Add and edit of a company (user);
- Issue invoices and payments;
- Management of clients for each user;
- Management of products and services provided by the user;
- Reports and statistics for user (company) for issued invoices, products/services sold, payments in total invoices or for each client, most sold products or services etc. The project will have different tables with different relationship among them, such as:
- Users (companies);
- Clients;
- Products/services;
- Invoices;
- Products of invoices;
- Billing addresses;
- Payments; and static tabels, such as:
- City;
- Country;
- Vat rate;
- Currency;
- Banks;
- Company type;
- User type;
- Product type;
- Unit type;
- Payment type;
- Contact person. 
The Maven project will use JPA repositories, HTML templates and CSS styles and 
will provide an on line template for issuing invoices by the signed in users to their clients, 
along with payments and providing reports for anlysing the past activities in order to take better decisions in the future and see the market trends.