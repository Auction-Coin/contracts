import org.ergoplatform.ErgoAddressEncoder
import org.ergoplatform.appkit.{ConstantsBuilder, ErgoClient, NetworkType, RestApiErgoClient}

object Main {
  val ergoClient: ErgoClient = RestApiErgoClient.create("http://95.217.135.15:9053/", NetworkType.MAINNET, "", "https://api.ergoplatform.com/api/v1/")
  val addrEnc = new ErgoAddressEncoder(NetworkType.TESTNET.networkPrefix)

  val mainContract: String = Contracts.main;
  def main(args: Array[String]): Unit = {
    // use appkit to compile the contract
    ergoClient.execute(ctx => {
      var contract = ctx.compileContract(ConstantsBuilder.create().build(), mainContract)
      println("Main contract address: " + addrEnc.fromProposition(contract.getErgoTree).get)

    })


  }
}