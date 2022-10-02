# Cucumber-BDD-Framework
Hello, Everyone 
This is a Testing Framework  Based on 'SRP' (Single Responsibility of  Page) with BDD approach. Here I have used following tools and technologies - maven compiler plugin, maven fail safe plugin (for parallel execution), maven sure fire plugin, The template of the project is 'Maven archetype qucikstart -1.4'
According to 'SRP' principle, in this project each class will have its own responsibility.In this Project I am going to create following segments,
(1) Feature Layer for each feature (not for each scenarios)
(2) Step Definition Layer for respective feature (TestCases will be writtern here)
(3) Runner package
(4) PageLayer (By.Locators will be declared here)
(5) Driver Factory (Based on concept of 'Thread local from java -8')
(6) Utility package
(7) Resources for Reporting
(8) Hooks for preconditions and postconditions
