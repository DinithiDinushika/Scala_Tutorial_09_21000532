object Q4 {

  def main(args: Array[String]): Unit = {
    val accountsList = List(
      new Account(1, 2000.00),
      new Account(2, -1000.00),
      new Account(3, 2500.00),
      new Account(4, -500.00),
      new Account(5, 1500.00),
    )

    val negBalAccounts = accountsList.filter(_.balance < 0)
    println("Accounts with negative balances:")
    negBalAccounts.foreach(println)

    val sumOfBalances = accountsList.map(_.balance).sum
    println("\nSum of all account balances: " + sumOfBalances)

    def interest(account: Account): Account = {
      if(account.balance > 0){
        //deposit interest is 0.05
        account.balance += account.balance * 0.05
      }
      else{
        //overdraft interest is 0.1
        account.balance += account.balance * 0.1
      }
      account
    }

    val intAppliedAccounts = accountsList.map(interest)
    println("\nFinal balances of all accounts after applying the interest:")
    intAppliedAccounts.foreach(println)
  }

  class Account(val accountId: Int, var balance: Double) {

    def Deposit(depositAmount: Double): Unit = {
      this.balance = this.balance + depositAmount
    }

    def Withdraw(withdrawAmount: Double): Unit = {
      if (this.balance >= withdrawAmount) {
        this.balance = this.balance - withdrawAmount
      }
      else {
        println("Insufficient balance")
      }
    }

    def Transfer(transAmount: Double, givenAccount: Account): Unit = {
      if (this.balance >= transAmount) {
        this.Withdraw(transAmount)
        givenAccount.Deposit(transAmount)

      }
      else {
        println("Insufficient balance")
      }
    }

    override def toString: String = s"Account ID: $accountId, Balance: $balance"
  }


}
