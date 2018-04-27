package ch.carve.cassandra;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "jax",
        name = "trx",
        readConsistency = "QUORUM",
        writeConsistency = "QUORUM",
        caseSensitiveKeyspace = false,
        caseSensitiveTable = false)
public class TrxRecord {

    @PartitionKey
    private long trxid;
    private int amount;
    private String merchant;

    public TrxRecord() {
        // used by mapper
    }

    public TrxRecord(long trxid, int amount, String merchant) {
        super();
        this.trxid = trxid;
        this.amount = amount;
        this.merchant = merchant;
    }

    public long getTrxid() {
        return trxid;
    }

    public void setTrxid(long trxid) {
        this.trxid = trxid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

}
