//package com.javaedge.oss;
//
///**
// * @author JavaEdge
// * @date 2024/3/6
// */
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
//        // 强烈建议不要把访问凭证保存到工程代码里，否则可能导致访问凭证泄露，威胁您账号下所有资源的安全。本代码示例以从环境变量中获取访问凭证为例。运行本代码示例之前，请先配置环境变量。
//        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
//        // 填写源Bucket名称，例如src-bucket。
//        String bucketName = "src-bucket";
//        // 指定数据要复制到的目标Bucket。目标Bucket与源Bucket必须属于不同账号。
//        String targetBucketName = "dest-bucket";
//        // 指定目标Bucket所在地域。目标Bucket与源Bucket必须处于不同地域。
//        String targetBucketLocation = "oss-ap-southeast-2";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
//
//        try {
//            AddBucketReplicationRequest request = new AddBucketReplicationRequest(bucketName);
//            request.setTargetBucketName(targetBucketName);
//            request.setTargetBucketLocation(targetBucketLocation);
//            // 默认复制历史数据。此处设置为false，表示禁止复制历史数据。
//            request.setEnableHistoricalObjectReplication(false);
//            // 指定授权OSS进行数据复制的角色名称，且该角色必须已被授予源Bucket执行跨区域复制以及目标Bucket接收复制对象的权限。
//            request.setSyncRole("yourRole");
//            //List prefixes = new ArrayList();
//            //prefixes.add("image/");
//            //prefixes.add("video");
//            //prefixes.add("a");
//            //prefixes.add("A");
//            // 指定待复制Object的前缀Prefix。指定Prefix后，只有匹配该Prefix的Object才会复制到目标Bucket。
//            //request.setObjectPrefixList(prefixes);
//            //List actions = new ArrayList();
//            //actions.add(AddBucketReplicationRequest.ReplicationAction.ALL);
//            // 指定可以被复制到目标Bucket的操作。默认值为ALL，表示源Bucket的所有操作都会复制到目标Bucket。
//            //request.setReplicationActionList(actions);
//            ossClient.addBucketReplication(request);
//        } catch (OSSException oe) {
//            System.out.println("Caught an OSSException, which means your request made it to OSS, "
//                    + "but was rejected with an error response for some reason.");
//            System.out.println("Error Message:" + oe.getErrorMessage());
//            System.out.println("Error Code:" + oe.getErrorCode());
//            System.out.println("Request ID:" + oe.getRequestId());
//            System.out.println("Host ID:" + oe.getHostId());
//        } catch (ClientException ce) {
//            System.out.println("Caught an ClientException, which means the client encountered "
//                    + "a serious internal problem while trying to communicate with OSS, "
//                    + "such as not being able to access the network.");
//            System.out.println("Error Message:" + ce.getMessage());
//        } finally {
//            if (ossClient != null) {
//                ossClient.shutdown();
//            }
//        }
//    }
//}
