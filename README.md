# Recommender-Hadoop
Writing scalable recommender system with Hadoop. Implementation of very simple "people we might know" recommender algorithm on Apache Hadoop

####Our graph contains the input file with the first character of every line as source and the following characters as their neighbors connecting them.

#####Note that if there's a node from A to B then there's a node from B to A also.

### Our Input File

>A B

>B A D C

>C B D E I

>D B C H

>E C G F

>F E H

>H F D I

>G E

>I C H

**Note** - I have created 2 Mappers and Reducers and we run 2 jobs and the output of the first job becomes the input of the next job.

The Input file and the First Job Running:
![](https://raw.githubusercontent.com/LakshayNagpal/Recommender-Hadoop/master/images/1.png)

so the Output of the first Reducer is this:
![](https://raw.githubusercontent.com/LakshayNagpal/Recommender-Hadoop/master/images/2.png)
