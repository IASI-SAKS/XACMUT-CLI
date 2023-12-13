# XACMUT-CLI
Simple CLI for the tool XACMUT.

This repository uses XACMUT version 2.0 which is shipped with the JAR included in the folder [lib](lib).
The [POM](pom.xml) explicitly links to this library.

For more information about XACMUT see at:
 * [XACMUT Official Page](http://labsedc.isti.cnr.it/tools/xacmut) at [LabSEDC ISTI-CNR](http://labsedc.isti.cnr.it)
 * [Said Daoudagh's Space](https://github.com/saiddao/XACMUT) on GitHub
 
## How to Configure it

XACMUT-CLI will look for XACML policy files into the directory:
 * [src/main/resources/policies](src/main/resources/policies)

Load here your XACML policy files.
For each file in the directory, XACMUT-CLI will generate mutants by using all mutant operators supported by XACMUT

In future release there may be some support for picking policies from a given directory or for selecting specific mutant operators.


## How to Run it

Run XACMUT-CLI with the following command:
 * ```mvn clean compile exec:java```
 
