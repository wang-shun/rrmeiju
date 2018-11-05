package com.caizhukui.rrmeiju.service.cloudstorage;

import java.util.List;

import org.junit.Test;

import com.caizhukui.cloudstorage.CloudStorageService;
import com.caizhukui.core.consts.CloudStorageConstant;
import com.caizhukui.rrmeiju.service.BaseServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import junit.framework.TestCase;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月29日
 */
public abstract class CloudStorageServiceTest extends BaseServiceTest {

    /** 不存在的桶名称 */
    private static final String NONEXIST_BUCKET_NAME = "whatever";
    
    private static final String NEW_BUCKET_NAME = "new";
    
    private static final String LOCAL_FILE_PATH = "D:/test-image.jpg";
    
    private static final String OBJECT_KEY = "test/test-image.jpg";

    /**
     * 查询空间是否存在
     * 
     * @author caizhukui
     * @date 2018年4月29日
     */
    @Test
    public void testDoesBucketExist() {
        boolean exists = cloudStorageService().doesBucketExist(CloudStorageConstant.BUCKET_NAME);
        TestCase.assertEquals(true, exists);
        exists = cloudStorageService().doesBucketExist(NONEXIST_BUCKET_NAME);
        TestCase.assertEquals(false, exists);
    }
    
    /**
     * 获取所有空间名称
     * 
     * @author caizhukui
     * @date 2018年4月29日
     */
    @Test
    public void testListBuckets() {
        List<String> bucketNames = cloudStorageService().listBucketNames();
        systemOut(bucketNames);
        assertThat(bucketNames, hasItem(CloudStorageConstant.BUCKET_NAME));
    }
    
    @Test
    public void testListObjectNames() {
        final int limit = 20;
        List<String> objectNames = cloudStorageService().listObjectNames(CloudStorageConstant.BUCKET_NAME, "test/", "", limit, CloudStorageConstant.DELIMITER);
        systemOut(objectNames);
        TestCase.assertTrue(objectNames.size() > 0);
    }

    /**
     * 测试新建和删除空间
     * 
     * @author caizhukui
     * @date 2018年4月29日
     */
    @Test
    public void testCreateAndDeleteBucket() {
        boolean success = cloudStorageService().createPublicReadBucket(NEW_BUCKET_NAME);
        TestCase.assertEquals(true, success);
        success = cloudStorageService().deleteBucket(NEW_BUCKET_NAME);
        TestCase.assertEquals(true, success);
    }
    
    /**
     * 测试上传和删除文件
     * 
     * @author caizhukui
     * @date 2018年4月29日
     */
    @Test
    public void testPutAndDeleteObject() {
        boolean success = cloudStorageService().putObject(CloudStorageConstant.BUCKET_NAME, OBJECT_KEY, LOCAL_FILE_PATH);
        TestCase.assertEquals(true, success);
        success = cloudStorageService().deleteObject(CloudStorageConstant.BUCKET_NAME, OBJECT_KEY);
        TestCase.assertEquals(true, success);
    }
    
    /**
     * 获取云存储服务
     * 
     * @return CloudStorageService
     * @author caizhukui
     * @date 2018年4月29日
     */
    protected abstract CloudStorageService cloudStorageService();

}
