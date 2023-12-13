# Pharmaceutical-Distribution-Network

#Introduction

The Pharmaceutical Distribution Network project is about managing how drugs are made, sent out, and given to people. It uses technology and good planning to make sure drugs are made right, moved safely, and get to where they need to be when they need to be there, all while following the rules.

#Problem Statement

The process of getting, moving, storing, and delivering medicines is what the medicine supply chain is all about. These medicines are very important, so it's key to keep them safe and in good condition the whole time. But, there are some tough parts in handling this process. These include counterfeit drugs, drug shortages, supply chain disruptions, and inadequate visibility into the supply chain.

#Solution

Managing the medicine supply chain means working with many different groups like drug makers, distributors, wholesalers, clinics, hospitals, and patients. To make sure drugs are there when needed, in the right amount, and at a fair price, all these groups need to work together and talk to each other. The goal is to create a system that can handle these issues well and keep the quality and safety of medicines high from start to finish. This system should let us see what's happening in the supply chain in real-time, track where drugs are, stop fake drugs from getting in, keep enough stock to avoid running out of drugs, and quickly deal with any problems in the supply process. It's also important that this system follows all the rules and standards that are there to make sure drugs are safe and work well.

#Enterprises:

1. FDA
2. Hospital
3. Manufacturer
4. Provider
5. Distributor
6. State Health Department

#Organizations:

1. Clinic Organization
2. FDA Organization
3. State Health Department Organization
4. Medical Organization
5. Distributor Organization
6. Manufacturer Organization
7. Hospital Organization
8. Patient Organization

#Roles:

1. System Admin
2. FDA Admin
3. State Health Admin
4. Distributor Admin
5. Provider Admin
6. Manufacturer Admin
7. Doctor
8. Clinic
9. Patient
10. FDA organization employee
11. Medical organization employee
12. State Health Department employee
13. Distributor employee
14. Provider employee
15. Manufacturer employee

#Flow Of The System:

1. The System Administrator is able to log in, adding new states, cities, diseases, drug manufacturers, drug providers, manage drug catalogs, and create accounts for the FDA administrator, State Health Department administrator, Distributor administrator, and Provider administrator.
2. Upon logging in, the State Health Department administrator can add state population data to the system.
3. The FDA administrator has the ability to log in and create accounts for FDA employees and medical organization employees.
4. An FDA employee can log in to order medicine, which will then be processed and moved to the manufacturer panel.
5. Upon logging in, the Manufacturer administrator can create manufacturer user accounts. These users can manage drug products, view orders placed by FDA employees, and assign orders to themselves. Manufacturer users will be responsible for processing orders.
6. The Distributor administrator can log in and create distributor user accounts. Users can then create location-specific warehouses and view processed orders from manufacturers. Once the order has been received, it can be stored in the warehouse, which will store the fixed amount of drugs as per the order processed by the manufacturer.
7. The Provider administrator can log in and create accounts for doctors, patients, and clinic users.
8. Upon logging in, doctors and clinics can place orders for the required drugs. Doctors can also view and manage their orders.
9. After the orders have been placed, the State Health Department administrator can log in to approve them.
10. Once the State Health Department approves the orders, the FDA administrator can then approve them.
11. Distributor users will then log in to approve and ship the orders. They can check the drug inventory in the warehouse. If the requested quantity is not available, the orders will not be shipped.
12. Once the orders have been shipped and received, the doctor can log in to store the drugs in the hospital inventory. Doctors can administer the drugs to the patients once they are available.
13. The patient can then log in to view their immunization history and download their vaccine certificate.
14. Similarly, clinics can place orders for medicines, follow the approval process, and administer immunizations to patients.

#Architecture Diagram:

![image](https://github.com/anzalshaikh27/Pharmaceutical-Distribution-Network/assets/57680301/28e2d990-d03f-45c7-9c85-4ad5755e2f8a)

#Component Diagram:

![image](https://github.com/anzalshaikh27/Pharmaceutical-Distribution-Network/assets/57680301/55734e05-2f92-422f-873d-0c66b253c57c)

#Conclusion:

Effective drug supply chain management is essential for ensuring that patients have access to safe, effective, and affordable drugs. It can also help reduce drug shortages, minimize waste, and improve patient outcomes.
