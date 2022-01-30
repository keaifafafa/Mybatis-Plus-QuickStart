package com.fafa.mptestdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fafa.mptestdemo.entity.User;
import com.fafa.mptestdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan("com.fafa.mptestdemo.mapper")
class MptestdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部用户
     */
    @Test
    void findAll() {
        // 查询全部用户（里面的参数是筛选条件，可不选）
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    /**
     * 添加用户
     */
    @Test
    void testAdd() {
        // 数据库插入id值默认为：全局唯一id(自己无法手动添加)
        User user = new User();
        user.setAge(21);
        user.setEmail("66666888@qq.com");
        user.setName("王五");
        // 成功添加的数据条数
        int insert = userMapper.insert(user);
        System.out.println("成功添加" + insert + "条数据");
    }

    /**
     * 测试更新功能
     */
    @Test
    public void testUpdate() {
        // long类型数字后应加 L
        User user = userMapper.selectById(1487697060100259842L);
        user.setName("U_乐观锁02");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    /**
     * 测试多个id批量查询
     */
    @Test
    public void testSelect1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    /**
     * 简单条件查询
     */
    @Test
    public void testSelect2() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }

    /**
     * 分页查询
     */
    @Test
    public void testSelectPage(){
        // 起始下标 和 每页大小
        Page<User> page = new Page(1,3);
        // 将分页条件传入
        Page<User> userPage = userMapper.selectPage(page, null);
        // 总页数
        long pages = userPage.getPages();
        // 当前页号
        long current = userPage.getCurrent();
        // 当前页内容大小
        long size = userPage.getSize();
        // 总记录数（表中一共多少条数据）
        long total = userPage.getTotal();
        // 是否有下一页
        boolean hasNext = userPage.hasNext();
        //  查询到的数据集合
        List<User> userList = userPage.getRecords();
        // 是否有上一页
        boolean hasPrevious = userPage.hasPrevious();
        System.out.println(pages);
        System.out.println(current);
        System.out.println(size);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
        System.out.println(userList);
    }

    /**
     * 根据id删除用户（物理删除）
     */
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(5L);
        System.out.println(result);
    }

    /**
     * 批量删除
     */
    @Test
    public void testMultipleDelete(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(i);
    }

    /**
     * 简单的条件删除
     */
    @Test
    public void testDeleteByMap(){
        // 第二个参数要用对象
        Map<String, Object> map = new HashMap<>();
        map.put("age",20);
        map.put("name","可爱发");
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    /**
     * 逻辑删除（便于数据恢复）
     */
    @Test
    public void testLogicDelete(){
        int i = userMapper.deleteById(1487736899679997953L);
        System.out.println(i);
    }


}
