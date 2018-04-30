# AQR Position Service Simulator

## Solution
### Running the application

`./gradlew build`

`java -jar aqr-1.0-SNAPSHOT.jar ../../data/fills.gz ../../data/prices.gz`

## Requirements
### Background
When designing a trading system, we have to think about how to maintain our current position, and track our P&L. Your task is to develop a simple simulator of a simplified position service. 
When you purchase or sell a security on the stock exchange, the exchange will send you a message indicating the amount you bought/sold, the price that it was transacted at, and whether you bought or sold the security.  
In order to keep track of enough information to calculate P&L we need to keep track of the current size owned, as well as the amount of “cash” spent buying or selling the securities. Note, it is possible to sell a security without owning it, this is called a “short” position, and would be represented as a negative number in your position. 
At any given moment we likely still own a sizeable position in any given security. Thus, we consider P&L to be the total “cash” that we are keeping track of in the position service plus the mark to market value of our current holdings. 

### Task
Your program will take a time series of fillOrder and price update messages, and produce a list of PNL messages. You will output one PNL message for each Price Update message. Please note that the timestamps in the fillOrder message file and the timestamps in the price update message file are comparable. You are essentially replaying time.
Your program will take two arguments, the path of the fills/price files, and should write PNL Message messages to stdout. You may write this in any language you choose provided it can be easily run and compiled on either windows or linux.
positionservice.sh fills.gz prices.gz

### I/O
#### Fill Message
The fillOrder log file {fills.gz} contains a time ordered list of Fill Messages.

The space separated format is organized as follows:

`F 1388534400000 MSFT 42.43 300 B`

`F 1388534400000 AAPL 181.26 300 B`

`F 1388534472953 MSFT 42.93 300 S`

1)	Message type:  This is always F for this file
2)	Milliseconds from the unix epoch
3)	Symbol name
4)	Fill Price
5)	Fill size
6)	Side indicator (B for buy and S for sell)
 
#### Price Update Message
The prices log file {prices.gz} contains a time ordered list of Price Update Messages.

The space separated format is organized as follows:

`P 1388534400000 MSFT 42.43`

`P 1388534400000 AAPL 181.26`

1)	Message type: This is always P for this file
2)	Milliseconds from the unix timestamp
3)	Symbol name
4)	Current price

#### PNL Message
This is the output format you will write.

The space separated format is organized as follows:

`PNL 1420063200000 MSFT 48100 -61888.51`

`PNL 1420063200000 AAPL 48100 -103147.52`

`PNL 1420066800000 MSFT 49400 -174554.88`

1)	Message type: This is always PNL for this file
2)	Milliseconds from the unix timestamp
3)	Symbol name
4)	Signed Size Owned  
5)	Mark to Market P&L
