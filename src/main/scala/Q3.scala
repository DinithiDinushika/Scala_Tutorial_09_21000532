object Q3 {
  def main(args: Array[String]): Unit = {

    val account1 = new Account(1, 2500.00)
    val account2 = new Account(2, 1000.00)

    println("----------Status of accounts before transactions-----------")
    println("Status of Account 1:")
    println(account1)
    println("Status of Account 2:")
    println(account2)

    account1.Deposit(500.00)
    account2.Withdraw((500.00))
    account1.Transfer(1000.00, account2)

    println("\n----------Status of accounts after transactions------------")
    println("Status of Account 1:")
    println(account1)
    println("Status of Account 2:")
    println(account2)

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
