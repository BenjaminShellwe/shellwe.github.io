<template>
    <div>
        <page-header title="企业账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为企业账户的基本设置
                </div>
            </template>
        </page-header>
        <page-main title="企业账户">
            <el-row style="margin-bottom: 5px;">
                <el-col style="display: inline-block;">
                    <Auth :value="'permission.department'" style="display: inline-block; margin-right: 5px;">
                        <el-button type="primary" size="mini" @click="pageLogin('E')">启用企业管理账户</el-button>
                        <template slot="no-auth">
                            你没有该权限进入企业管理页面
                        </template>
                    </Auth>
                    <el-button type="primary" size="mini" @click="pageLogin('P')">启用企业个人账户</el-button>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisible" :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-descriptions class="margin-top" title="企业基本信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small" @click="reload(2)">刷 新</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterprise" />
                                    名 称
                                </template>
                                {{ pageValue.name }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterpriseID" />
                                    企业标识
                                </template>
                                {{ pageValue.id }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="representative" />
                                    企业法人
                                </template>
                                {{ pageValue.representative }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    地 址
                                </template>
                                {{ pageValue.location }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    类 型
                                </template>
                                <el-tag size="small">{{ pageValue.type }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    联系地址
                                </template>
                                {{ pageValue.address }}
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                    <el-row>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px; margin-right: 5px;">
                                <el-table
                                    :data="pageTableData.filter(data => !pageSearch || data.name.toLowerCase().includes(pageSearch.toLowerCase()))"
                                    style="width: 100%;"
                                >
                                    <el-table-column
                                        label="职员ID"
                                        prop="userID"
                                    />
                                    <el-table-column
                                        label="账户状态"
                                        prop="status"
                                    />
                                    <el-table-column
                                        label="职员名称"
                                        prop="realName"
                                    />
                                    <el-table-column
                                        align="right"
                                    >
                                        <template slot="header">
                                            <el-input
                                                v-model="pageSearch"
                                                size="mini"
                                                placeholder="输入关键字搜索"
                                                style="width: 135px;"
                                            />
                                        </template>
                                    </el-table-column>
                                </el-table>
                            </el-card>
                        </el-col>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px; margin-left: 5px;">
                                <div class="Echarts">
                                    <div id="chartsUni" style="width: 705px; height: 373px;" />
                                </div>
                            </el-card>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisibleUni" :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-descriptions class="margin-top" title="企业职员信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small" @click="reload(2)">刷 新</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user" />
                                    职员姓名
                                </template>
                                {{ pageValueUni.realName }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile" />
                                    工作电话
                                </template>
                                {{ pageValueUni.phone }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="representative" />
                                    所属职位
                                </template>
                                <el-tag size="small">{{ pageValueUni.position }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    备注信息
                                </template>
                                {{ pageValueUni.remarks }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    企业名称
                                </template>
                                <el-tag size="small">{{ pageValueUni.enterpriseName }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    账号状态
                                </template>
                                {{ pageValueUni.status }}
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisible" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-tabs title="行政管理(仅是展示)">
                            <el-tab-pane label="办公空间(建立)" name="first">
                                <el-collapse accordion>
                                    <el-collapse-item title="1.1 选址" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="1.2 租赁" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="1.3 装修" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="1.4 搬迁" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="办公环境(维护)" name="second">
                                <el-collapse accordion>
                                    <el-collapse-item title="2.1 卫生" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="2.2 环境(照明,温湿,空气)" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="2.3 绿植" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="2.4 公共空间" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="2.5 报修" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="2.6 安保" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="采购管理(买进)" name="third">
                                <el-collapse accordion>
                                    <el-collapse-item title="3.1 小额报销采购" name="1">
                                        <el-collapse accordion>
                                            <el-collapse-item title="3.1.1 采购" name="11">
                                                <div>不实现</div>
                                            </el-collapse-item>
                                            <el-collapse-item title="3.1.2 报销" name="22">
                                                <div>不实现</div>
                                            </el-collapse-item>
                                            <el-collapse-item title="3.1.3 记账" name="33">
                                                <div>不实现</div>
                                            </el-collapse-item>
                                        </el-collapse>
                                    </el-collapse-item>
                                    <el-collapse-item title="3.2 合同对公采购(照明,温湿,空气)" name="2">
                                        <el-collapse-item title="3.2.1 采购申请" name="111">
                                            <div>不实现</div>
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.2 供应商登记" name="222">
                                            <div>不实现</div>
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.3 合同审批" name="333">
                                            <div>不实现</div>
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.4 支付与验收" name="444">
                                            <div>不实现</div>
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.5 入账" name="555">
                                            <div>不实现</div>
                                        </el-collapse-item>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="资产维护(维护)" name="fourth">
                                <el-collapse accordion>
                                    <el-collapse-item title="4.1 入库出库" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="4.2 维修维护" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="4.3 盘点" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="4.4 报废" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="IT运维(运维)" name="fifth">
                                <el-collapse accordion>
                                    <el-collapse-item title="5.1 计算机调试维修维护" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="5.2 网络设施通信维护" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="5.3 数据维护" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="5.4 企业邮件管理" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="其它事务" name="sixth">
                                <el-collapse accordion>
                                    <el-collapse-item title="6.1 接待" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="6.2 会议" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="6.3 差旅" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="6.4 通知" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="科技项目" name="seventh">
                                <el-collapse accordion>
                                    <el-collapse-item title="7.1 项目规划" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="7.2 项目立项" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="7.3 项目申报" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="7.4 项目验收" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="供应商管理" name="eighth">
                                <el-collapse accordion>
                                    <el-collapse-item title="8.1 按程序" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="8.2 按对象" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="行政费用管理" name="ninth">
                                <el-collapse accordion>
                                    <el-collapse-item title="9.1 预算编制" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="9.2 预算执行项" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="9.3 预算分析" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="9.4 预算控制" name="4">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="制度流程" name="tenth">
                                <el-collapse accordion>
                                    <el-collapse-item title="10.1 制度规定" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="10.2 工作流程" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="10.3 执行标准" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="团队建设" name="eleventh">
                                <el-collapse accordion>
                                    <el-collapse-item title="11.1 部门工作职责梳理" name="1">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="11.2 部门工作分配协调" name="2">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                    <el-collapse-item title="11.3 人员规划与指导" name="3">
                                        <div>不实现</div>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                        </el-tabs>
                    </el-card>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisible" style="margin-bottom: 5px;">
                <el-col :span="12">
                    <el-card shadow="hover" style="margin-right: 5px;">
                        <span>员工录入</span>
                        <el-form ref="pageRuleForm" :model="pageRuleForm" :rules="rules">
                            <el-row type="flex">
                                <el-col :span="12">
                                    <el-form-item label="员工真实姓名" prop="realName" label-width="120px">
                                        <el-input v-model="pageRuleForm.realName" size="mini" style="width: 160px;" />
                                    </el-form-item>
                                    <el-form-item label="员工电话号码" prop="phoneNumber" label-width="120px">
                                        <el-input v-model="pageRuleForm.name" size="mini" style="width: 160px;" />
                                    </el-form-item>
                                    <el-form-item label="员工出生年月" label-width="120px" required>
                                        <el-form-item prop="date">
                                            <el-date-picker v-model="pageRuleForm.date1" type="date" placeholder="选择日期" style="width: 160px;" size="mini" />
                                        </el-form-item>
                                    </el-form-item>
                                    <el-form-item label="员工所属部门" prop="department" label-width="120px" size="mini">
                                        <el-select v-model="pageRuleForm.region" placeholder="请选择所属部门" style="width: 160px;">
                                            <el-option label="人事部门" value="personnel" />
                                            <el-option label="软件部门" value="software" />
                                            <el-option label="教辅部门" value="education" />
                                            <el-option label="行政部门" value="administrative" />
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="补充内容" prop="more" label-width="120px">
                                        <el-input v-model="pageRuleForm.name" size="mini" style="width: 160px;" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="12">
                                    <el-form-item label="政治面貌" prop="political" label-width="120px">
                                        <el-input v-model="pageRuleForm.name" size="mini" style="width: 190px;" />
                                    </el-form-item>
                                    <el-form-item label="员工账户" prop="account" label-width="120px">
                                        <el-select
                                            v-model="pageSelectValue"
                                            filterable
                                            allow-create
                                            remote
                                            reserve-keyword
                                            placeholder="可查询,可新建(不可重复)"
                                            :remote-method="handleRemoteMethod"
                                            :loading="pageLoading"
                                            style="width: 190px;"
                                            size="small"
                                        >
                                            <el-option
                                                v-for="item in options"
                                                :key="item.value"
                                                :label="item.label"
                                                :value="item.value"
                                            />
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="员工性别" prop="gender" label-width="120px" size="small">
                                        <el-select v-model="pageRuleForm.region" placeholder="请选择" style="width: 190px;">
                                            <el-option label="先生" value="personnel" />
                                            <el-option label="女士" value="software" />
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="员工职位" prop="position" label-width="120px" size="small">
                                        <el-select v-model="pageRuleForm.region" placeholder="请选择职位" style="width: 190px;">
                                            <el-option label="人事部门" value="personnel" />
                                            <el-option label="软件部门" value="software" />
                                            <el-option label="教辅部门" value="education" />
                                            <el-option label="行政部门" value="administrative" />
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="补充内容" prop="more2" label-width="120px">
                                        <el-input v-model="pageRuleForm.name" size="mini" style="width: 160px;" />
                                    </el-form-item>
                                </el-col>
                            </el-row>
                            <el-form-item label="立即审核" label-width="120px" prop="delivery">
                                <el-switch v-model="pageRuleForm.audit" />
                            </el-form-item>
                            <el-form-item label="补充内容" label-width="120px" prop="type">
                                <el-checkbox-group v-model="pageRuleForm.content">
                                    <el-checkbox label="内容1" name="content1" />
                                    <el-checkbox label="内容2" name="content2" />
                                    <el-checkbox label="内容3" name="content3" />
                                    <el-checkbox label="内容4" name="content4" />
                                </el-checkbox-group>
                            </el-form-item>
                            <el-form-item label="招聘来源" label-width="120px" prop="resource">
                                <el-radio-group v-model="pageRuleForm.source">
                                    <el-radio label="线上" />
                                    <el-radio label="线下" />
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="补充内容" label-width="120px" prop="desc">
                                <el-input v-model="pageRuleForm.more3" type="textarea" />
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="handleSubmitForm('pageRuleForm')">入库</el-button>
                                <el-button @click="handleResetForm('pageRuleForm')">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </el-card>
                </el-col>
                <el-col :span="12">
                    <el-card shadow="hover" style="margin-left: 5px;">
                        <el-card shadow="hover" style="margin-top: 5px; margin-right: 5px;">
                            <el-table
                                :data="pageTableData.filter(data => !pageSearch || data.name.toLowerCase().includes(pageSearch.toLowerCase()))"
                                style="width: 100%; height: 150px;"
                            >
                                <el-table-column
                                    label="职员ID"
                                    prop="userID"
                                />
                                <el-table-column
                                    label="职员名称"
                                    prop="realName"
                                />
                                <el-table-column
                                    align="right"
                                >
                                    <template slot="header">
                                        <el-input
                                            v-model="pageSearch"
                                            size="mini"
                                            placeholder="输入关键字搜索"
                                            style="width: 135px;"
                                        />
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-card>
                        <div>
                            <el-form v-model="pageDataForm" label-width="100px" size="small" label-position="right">
                                <div>
                                    <el-form-item label="真实姓名" prop="realName" class="inLine">
                                        <el-input v-model="pageDataForm.realName" :placeholder="pageDataForm.realName" auto-complete="off" />
                                    </el-form-item>
                                    <el-form-item label="账户名称" prop="nickName" class="inLine">
                                        <el-input v-model="pageDataForm.nickName" :placeholder="pageDataForm.nickName" auto-complete="off" />
                                    </el-form-item>
                                    <el-form-item label="手机号码" prop="phone" class="inLine">
                                        <el-input v-model="pageDataForm.phone" :placeholder="pageDataForm.phone" auto-complete="off" />
                                    </el-form-item>
                                    <el-form-item label="首页链接" prop="homeUrl" class="inLine">
                                        <el-input v-model="pageDataForm.homeUrl" :placeholder="pageDataForm.homeUrl" maxlength="18" />
                                    </el-form-item>
                                    <el-form-item label="QQ" class="inLine">
                                        <el-input v-model="pageDataForm.qq" :placeholder="pageDataForm.qq" />
                                    </el-form-item>
                                    <el-form-item label="微信" class="inLine">
                                        <el-input v-model="pageDataForm.wechat" :placeholder="pageDataForm.wechat" />
                                    </el-form-item>
                                    <el-form-item label="用户性别" prop="phone" class="inLine" style="width: 293px;">
                                        <el-select v-model="value" :placeholder="pageDataForm.sex" style="width: 100%;">
                                            <el-option
                                                v-for="item in options"
                                                :key="item.value"
                                                :label="item.label"
                                                :value="item.value"
                                            />
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="所属公司" prop="homeUrl" class="inLine">
                                        <el-input v-model="pageDataForm.enterprise" :placeholder="pageDataForm.enterprise" maxlength="18" />
                                    </el-form-item>
                                    <el-card shadow="hover" style="margin-bottom: 1px;">
                                        <span>企业基础权限</span>
                                        <div style="margin: 0 0;" />
                                        <el-checkbox v-model="checkAll1" :indeterminate="isIndeterminate" @change="handleCheckAllBasic">全选</el-checkbox>
                                        <el-checkbox-group v-model="basicCheckedAuthorities" @change="handleCheckedBasicChange">
                                            <el-checkbox v-for="basic in basicAuthorities" :key="basic" :label="basic">{{ basic }}</el-checkbox>
                                        </el-checkbox-group>
                                    </el-card>
                                    <el-card shadow="hover" style="margin-bottom: 0;">
                                        <span>企业高级权限</span>
                                        <div style="margin: 0 0;" />
                                        <el-checkbox v-model="checkAll2" :indeterminate="isIndeterminate" @change="handleCheckAllAdvance">全选</el-checkbox>
                                        <el-checkbox-group v-model="advanceCheckedAuthorities" @change="handleCheckedAdvanceChange">
                                            <el-checkbox v-for="advance in advanceAuthorities" :key="advance" :label="advance">{{ advance }}</el-checkbox>
                                        </el-checkbox-group>
                                    </el-card>
                                </div>
                            </el-form>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisibleUni">
                <el-col>
                    <el-card>
                        <el-row>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <div slot="header" class="clearfix">
                                        <span>工作日程</span>
                                    </div>
                                    <span>企业通知</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template slot-scope="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <span>部门通知</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template slot-scope="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <span>今日日程</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template slot-scope="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        已读
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                </el-card>
                            </el-col>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <div slot="header" class="clearfix">
                                        <span>事务申请</span>
                                    </div>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="会议申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('会议')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交会议申请
                                                    </template>
                                                    请申请前阅读注意事项
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">主管级别以上</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="请假申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('请假')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交请假申请
                                                    </template>
                                                    包括所有请假类型
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">合适理由及剩余假期</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="离职申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('离职')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交离职申请
                                                    </template>
                                                    认真思考后填写
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">符合劳务合同解除要求</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="自定义申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('自定义')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交自定义申请
                                                    </template>
                                                    提供基本申请模板
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">符合基本制度要求</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                </el-card>
                            </el-col>
                            <el-dialog
                                :title="pageDialogTitle + '申请'"
                                :visible.sync="dialogVisibleUni"
                                width="30%"
                                :before-close="handleClose"
                            >
                                <span>条件不满足也可以申请,但审核将会较为严格</span>
                                <div>
                                    申请理由：
                                    <el-input
                                        v-model="pageInput"
                                        placeholder="请填写原由"
                                        style="width: 350px;"
                                        size="mini"
                                    />
                                </div>
                                <div>
                                    附加内容：
                                    <el-input
                                        v-model="pageInputUni"
                                        placeholder="附加说明"
                                        style="width: 350px;"
                                        size="mini"
                                    />
                                </div>
                                <span slot="footer" class="dialog-footer">
                                    <el-button @click="dialogVisibleUni = false">取 消</el-button>
                                    <el-button type="primary" @click="dialogVisibleUni = false">确 定</el-button>
                                </span>
                            </el-dialog>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <span>事务状态</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template slot-scope="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-card>
                </el-col>
            </el-row>
            <div v-show="page.content">
                <el-col><span>statement:double click would closed the window button create.</span></el-col>
                <el-col>
                    <el-card>
                        <el-button-group style="margin-right: 10px;">
                            <el-button type="success" plain @click="pageValueChange('user')">用户信息总览(用户)</el-button>
                            <el-button type="primary" plain @click="pageValueChange('background')">背调信息总览(背调)</el-button>
                        </el-button-group>
                        <el-button-group style="margin-right: 10px;">
                            <el-button type="success" plain @click="pageValueChange('role')">角色信息总览(角色)</el-button>
                            <el-button type="primary" plain @click="pageValueChange('permission')">权限控制总览(权限)</el-button>
                            <el-button type="warn" plain @click="pageValueChange('performance')">绩效信息总览(绩效)</el-button>
                        </el-button-group>
                    </el-card>
                </el-col>
                <el-col v-if="page.subContent.user">
                    content of 用户信息总览(用户)
                </el-col>
                <el-col v-if="page.subContent.background">
                    content of 背调信息总览(背调)
                </el-col>
                <el-col v-if="page.subContent.role">
                    content of 角色信息总览(角色)
                </el-col>
                <el-col v-if="page.subContent.permission">
                    content of 权限控制总览(权限)
                </el-col>
                <el-col v-if="page.subContent.performance">
                    content of 绩效信息总览(绩效)
                </el-col>
                <el-col v-if="page.subContent.remain">
                    content of 保留内容
                </el-col>
            </div>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>
                开发中 暂时拒绝提交至后台 数据未更改<br>
                此页面将会优先开发企业页面
            </span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import axios from 'axios'
const cityOptions = ['上海', '北京', '广州', '深圳']
const basicAuthority = ['基本读取', '基本增加', '基本删除', '基本查询', '基本修改']
const advanceAuthority = ['高级读取', '高级增加', '高级删除', '高级查询', '高级修改']
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    inject: ['reload'],
    data() {
        return {
            dialogVisible: false,
            dialogVisibleUni: false,
            enterpriseID: '',
            pageInput: '',
            pageInputUni: '',
            pageDialogTitle: '',
            pageRowVisible: false,
            pageRowVisibleUni: false,
            pageSelectValue: [],
            size: 'small',
            pageSearch: '',
            pageLoading: false,
            options: [],
            pageRemoteValue: [],
            list: [],
            value: '',
            checkAll: false,
            checkAll1: false,
            checkAll2: false,
            checkedCities: ['上海', '北京'],
            cities: cityOptions,
            basicCheckedAuthorities: ['基本读取', '基本增加', '基本修改'],
            advanceCheckedAuthorities: [],
            basicAuthorities: basicAuthority,
            advanceAuthorities: advanceAuthority,
            isIndeterminate: true,
            pageEnterpriseNotice: [{}],
            pageDataForm: {
                realName: 'Benjamin Thomas Shellwe',
                nickName: 'shellwe',
                phone: '176***2321',
                homeUrl: 'http://shellwe.top',
                enterprise: 'TernaryProjectTeam',
                qq: '774****22',
                wechat: '176***2321',
                remarks: '',
                sex: ''
            },
            pageRuleForm: {
                realName: '',
                phoneNumber: '',
                department: '',
                date1: '',
                more: '',
                political: '',
                account: '',
                gender: '',
                position: '',
                more2: '',
                audit: false,
                content: '',
                source: '',
                more3: ''
            },
            rules: {
                name: [
                    { required: true, message: '请输入活动名称', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                region: [
                    { required: true, message: '请选择活动区域', trigger: 'change' }
                ],
                date1: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                date2: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                ],
                type: [
                    { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
                ],
                resource: [
                    { required: true, message: '请选择活动资源', trigger: 'change' }
                ],
                desc: [
                    { required: true, message: '请填写活动形式', trigger: 'blur' }
                ]
            },
            pageTableData: [{}],
            pageValue: {
                enterpriseID: '数据脱敏处理Example',
                name: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                representative: '数据脱敏处理Example',
                location: '数据脱敏处理Example',
                type: '数据脱敏处理Example',
                address: '数据脱敏处理Example'
            },
            pageValueUni: {
                department: '数据脱敏处理Example',
                enterpriseID: '数据脱敏处理Example',
                enterpriseName: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                phone: '数据脱敏处理Example',
                position: '数据脱敏处理Example',
                realName: '数据脱敏处理Example',
                remarks: '数据脱敏处理Example',
                status: '数据脱敏处理Example',
                userID: '数据脱敏处理Example'
            },
            page: {
                content: false,
                loginButton: true,
                subContent: {
                    user: false,
                    background: false,
                    role: false,
                    permission: false,
                    performance: false,
                    remain: false
                }
            }
        }
    },
    created() {
    },
    mounted() {
        this.echartsUni()
        this.handleGetValue()
    },
    methods: {
        back() {
            history.go(-1)
        },
        pageLogin(val) {
            if (val == 'E') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    that.pageValue.enterpriseID = response.data.data[0].enterpriseID
                    // console.log(that.pageValue.enterpriseID)
                    axios({
                        method: 'post',
                        url: '/enterprise/query/Info',
                        data: {
                            userID: that.pageValue.enterpriseID
                            // 测试数据
                            // userID: 123654
                        }
                    }).then(function(response) {
                        // console.log(response.data.data)
                        if (response.data.data == null) {
                            that.$message(response.data.msg)
                        } else {
                            that.pageRowVisible = true
                            that.pageValue = response.data.data[0]
                            // console.log(response.data.data)
                            // console.log(that.pageValue.)
                            // that.page.loginButton = false
                            axios({
                                method: 'post',
                                url: '/queryInfo/enterprise',
                                data: {
                                    enterpriseID: response.data.data[0].id
                                }
                            }).then(function(response) {
                                // console.log(response)
                                that.pageTableData = response.data.data
                            }).catch(function(error) {
                                console.log(error)
                            })
                        }
                    })
                }).catch(function(error) {
                    console.log(error)
                })
                // this.page.loginButton = false
                // this.page.content = true
            } if (val == 'P') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    if (response.data.data == null) {
                        that.$message(response.data.msg)
                    }
                    that.pageValueUni = response.data.data[0]
                    that.pageRowVisibleUni = true
                }).catch(function(error) {
                    console.log(error)
                })
            }
        },
        pageValueChange(val) {
            let value = new Boolean(value)
            value = this.page.subContent[val]
            this.$set(this.page.subContent, val, !value)
            console.log(this.page.subContent)
        },
        // handleGetValue 获取EID进行查询
        handleGetValue() {
            const that = this
            axios({
                method: 'post',
                url: '/user/query/EID',
                data: {
                    enterpriseID: 0
                }
            }).then(function(response) {
                // console.log(response)
                let t = {}
                let u = []
                response.data.data.forEach(function(item) {
                    for (let key in item) {
                        if (key == 'id') {
                            t[key] = item[key]
                        }
                    }
                    u.push(t)
                    t = {}
                    for (let key in u) {
                        if (u[key].id !== '' && u[key].id !== null) {
                            // console.log(u[key].id)
                            that.pageRemoteValue.push(u[key].id)
                            that.pageRemoteValue = that.pageRemoteValue.sort()
                            var array = [that.pageRemoteValue[0]]
                            for (var i = 1; i < that.pageRemoteValue.length; i++) {
                                if (that.pageRemoteValue[i] !== that.pageRemoteValue[i - 1]) {
                                    array.push(that.pageRemoteValue[i])
                                }
                            }
                            that.pageRemoteValue = array
                        }
                    }
                    t = {}
                    // console.log(that.pageRemoteValue)
                    // that.pageRemoteValue = u
                    // console.log(that.pageRemoteValue)
                    that.list = that.pageRemoteValue.map(item => {
                        return {value: `${item}`, label: `${item}`}
                    })
                    // console.log(that.pageRemoteValue.map)
                    // console.log(that.list)
                })
            }).catch(function(error) {
                console.log(error)
            })
        },
        handleRemoteMethod(query) {
            if (query !== '') {
                this.pageLoading = true
                setTimeout(() => {
                    this.pageLoading = false
                    this.options = this.list.filter(item => {
                        return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
                    })
                }, 1000)
                // console.log(this.list)
                // console.log(this.options)
            } else {
                this.options = []
            }
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            const data = {
                name: 'Chief',
                children: [
                    {
                        name: 'Manager',
                        children: [
                            { name: 'Supervisor', value: 8833 },
                            { name: 'Employee', value: 1732 },
                            { name: 'Other', value: 3623 }
                        ]
                    },
                    {
                        name: 'Inspector',
                        children: [{ name: 'Manager', value: 9116 }, { name: 'Other', value: 3623 }]
                    }
                ]
            }
            var data2 = {
                name: 'flare',
                children: [
                    {
                        name: 'flex',
                        children: [{ name: 'FlareVis', value: 4116 }]
                    },
                    {
                        name: 'scale',
                        children: [
                            { name: 'IScaleMap', value: 2105 },
                            { name: 'LinearScale', value: 1316 },
                            { name: 'LogScale', value: 3151 },
                            { name: 'OrdinalScale', value: 3770 },
                            { name: 'QuantileScale', value: 2435 },
                            { name: 'QuantitativeScale', value: 4839 },
                            { name: 'RootScale', value: 1756 },
                            { name: 'Scale', value: 4268 },
                            { name: 'ScaleType', value: 1821 },
                            { name: 'TimeScale', value: 5833 }
                        ]
                    },
                    {
                        name: 'display',
                        children: [{ name: 'DirtySprite', value: 8833 }]
                    }
                ]
            }
            // 配置图表
            var option = {
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                legend: {
                    top: '2%',
                    left: '3%',
                    orient: 'vertical',
                    data: [
                        {
                            name: 'tree1',
                            icon: 'rectangle'
                        },
                        {
                            name: 'tree2',
                            icon: 'rectangle'
                        }
                    ],
                    borderColor: '#c23531'
                },
                series: [
                    {
                        type: 'tree',
                        name: 'tree1',
                        data: [data],
                        top: '5%',
                        left: '7%',
                        bottom: '2%',
                        right: '60%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        emphasis: {
                            focus: 'descendant'
                        },
                        expandAndCollapse: true,
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    },
                    {
                        type: 'tree',
                        name: 'tree2',
                        data: [data2],
                        top: '20%',
                        left: '60%',
                        bottom: '22%',
                        right: '18%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        expandAndCollapse: true,
                        emphasis: {
                            focus: 'descendant'
                        },
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    }
                ]
            }
            chartUni.setOption(option)
        },
        handleSubmitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    alert('submit!')
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
        },
        handleResetForm(formName) {
            this.$refs[formName].resetFields()
        },
        handleCheckAllBasic(val) {
            this.basicCheckedAuthorities = val ? basicAuthority : []
            this.isIndeterminate = false
        },
        handleCheckedBasicChange(value) {
            let checkedCount1 = value.length
            this.checkAll = checkedCount1 === this.basicAuthorities.length
            this.isIndeterminate = checkedCount1 > 0 && checkedCount1 < this.basicAuthorities.length
        },
        handleCheckAllAdvance(val) {
            this.advanceCheckedAuthorities = val ? advanceAuthority : []
            this.isIndeterminate = false
        },
        handleCheckedAdvanceChange(value) {
            let checkedCount2 = value.length
            this.checkAll = checkedCount2 === this.advanceAuthorities.length
            this.isIndeterminate = checkedCount2 > 0 && checkedCount2 < this.advanceAuthorities.length
        },
        deleteRow(index, rows) {
            rows.splice(index, 1)
        },
        handleApplication(val) {
            this.pageDialogTitle = val
            this.dialogVisibleUni = true
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(function() {
                    done()
                })
                .catch(function() {

                })
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageStyle {
    margin-left: 5px;
    margin-bottom: 5px;
}
</style>
