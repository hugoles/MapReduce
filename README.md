# Bigram Counting using MapReduce

## Problem Definition
Given a set of input text documents (i.e., text files), create an index with the list of bigrams contained in these documents along with the number of times the bigrams were found across all documents. A bigram is a sequence of two adjacent elements from a sequence of tokens (in our case, words). A bigram is an n-gram for n = 2. For the sentence "The actions of Petrobras rise," we have the following bigrams "# The", "The actions", "actions of", "of Petrobras", "Petrobras rise", and "rise #", where the symbol # represents the whitespace.

## Input
The list of files is provided in a directory on HDFS (this directory can contain an arbitrary number of files), for example:
Some example files are attached to this activity. These files are classic books downloaded from the Gutenberg project website (https://www.gutenberg.org/).

## Output
The output consists of a file containing the list of bigrams identified in the input documents, along with the number of times the bigram was found in all documents. For example:

a boy 1
the cell 1
the horse 2

In the above example, the bigram "the horse" was found 2 times in total.
