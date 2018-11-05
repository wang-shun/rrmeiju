public class OTSTest {

	public static void main(String[] args) {
		/*final String accessKeyId = "LTAI3nQqL9trr7Sk";
		final String accessKeySecret = "Elj1mN3cpxB45SPHcXk4F6t7gfHrfU";
		final String endpoint = "http://caizhukui-test.cn-beijing.ots.aliyuncs.com";
		final String instanceName = "caizhukui-test";
		// 初始化OTSClient
		SyncClient otsClient = new SyncClient(endpoint, accessKeyId, accessKeySecret, instanceName);
		Television television = new Television();
		television.setTelevisionId(UuidUtil.getUuid());
		television.setTelevisionName("FOX");
		television.setTelevisionInfo("FOX Television");
		String pkValue = television.getTelevisionId();
		System.out.println(pkValue);
		final String PRIMARY_KEY_NAME = "television_id";
		final String TABLE_NAME = "television";
		// 构造主键
		PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
	    primaryKeyBuilder.addPrimaryKeyColumn(PRIMARY_KEY_NAME, PrimaryKeyValue.fromString(pkValue));
	    PrimaryKey primaryKey = primaryKeyBuilder.build();
	    RowPutChange rowPutChange = new RowPutChange(TABLE_NAME, primaryKey);
	    rowPutChange.addColumn(new Column("television_name", ColumnValue.fromString(television.getTelevisionName())));
	    rowPutChange.addColumn(new Column("television_info", ColumnValue.fromString(television.getTelevisionInfo())));
	    PutRowResponse response = otsClient.putRow(new PutRowRequest(rowPutChange));
	    String traceId = response.getTraceId();
	    System.out.println(traceId);
		pkValue = "FD4CF8B178F2430A804952F2E45CC5B0";
		// 构造主键
        PrimaryKeyBuilder primaryKeyBuilder = PrimaryKeyBuilder.createPrimaryKeyBuilder();
        primaryKeyBuilder.addPrimaryKeyColumn(PRIMARY_KEY_NAME, PrimaryKeyValue.fromString(pkValue));
        PrimaryKey primaryKey = primaryKeyBuilder.build();
        // 读一行
        SingleRowQueryCriteria criteria = new SingleRowQueryCriteria(TABLE_NAME, primaryKey);
        // 设置读取最新版本
        criteria.setMaxVersions(1);
        GetRowResponse getRowResponse = otsClient.getRow(new GetRowRequest(criteria));
        Row row = getRowResponse.getRow();
        System.out.println("读取完毕, 结果为: ");
        System.out.println(row);*/
	}

}
