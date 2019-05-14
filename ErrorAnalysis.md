# Title
## Course - Section 3
## Authors
Justin Boutin
Matteo Iaconetti
## Distributions of Model Accuracy
We get a different accuracy each time because of the method collections.shuffle. This shuffles the data points from the List chosen before taking a section to be tested. Instead of taking the same 30% to test our accuracy, it takes new values by shuffling the data.

The original  results are after 1000 loops:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The mean accuracy is: 96.91512195122% 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The standard deviation is: 1.2318914931588334

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The number of neighbours is: 5
  
Using the printLabelFrequencies method, the datasets are separated as roughly 65% benign and 35% malignant. Using this information a sensible baseline would be that 35% of our results are malignant AND 65% are benign. If we randomly assumed the entire data set were malignant our accuracy would be 35%, and consequently if we assumed benign our accuracy would be 65%.

## Analysis of different error types
A false positive is a result from a test that is incorrect. In this case a false positive would be a malignant result when it is in fact benign. 

A false negative is a wrong result indicating that someone does not have a condition. In this case, a benign result in a malignant tumor.

The Precision identifies the percentage of correctly predicted malignant over the total amount of predicted malignant individuals. Recall finds the correctly predicted malignant over the actual amount of malignant individuals.

Going above 5 neighbours lowers the average accuracy, choosing 3 neighbours increases the mean accuracy by 0.03. As the number increases the accuracy decreases. However, going below 3, which seems somewht ridiculous to do, lowers the accuracy. When increasing k the precision keeps increasing, however the recall decreases.


