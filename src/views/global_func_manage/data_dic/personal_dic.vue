<template>
    <div>
        <page-header>
            <template #content>
                <div>
                    <div @click="back" @mouseover="changeMask(true)" @mouseout="changeMask(false)">返回上一页</div>
                </div>
            </template>
        </page-header>
        <!-- 卡片视图区域 -->
        <el-card class="box-card itemSpacing">
            <el-form :inline="true">
                <!--卡片区域第一行-->
                <el-row>
                    <el-col :span="24">
                        <div>
                            <el-form-item />
                        </div>
                    </el-col>
                </el-row>
                <!--卡片区域第二行-->
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="模板名称" prop="modelName">
                            <el-input
                                size="small"
                                placeholder="请输入模板名称"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="备注" prop="notes">
                            <el-input
                                size="small"
                                placeholder="相关备注"
                                clearable
                            />
                        </el-form-item>
                    </el-col>

                    <el-col :span="8">
                        <div class="elbRight">
                            <el-button @click="dialogVisible = true">重置</el-button>
                            <el-button type="primary" @click="dialogVisible = true">查询</el-button>
                            <el-button type="primary" @click="dialogVisible = true">新增</el-button>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>

        <el-card class="box-card">
            <el-table
                :data="tableData"
                style="width: 100%;"
                max-height="250"
            >
                <el-table-column
                    fixed
                    prop="none"
                    label="列"
                    width="80"
                    type="index"
                />
                <el-table-column
                    fixed
                    prop="name"
                    label="名称"
                    width="300"
                />
                <el-table-column
                    prop="notes"
                    label="备注"
                    width="360"
                />
                <el-table-column
                    prop="state"
                    label="状态"
                    width="200"
                />
                <el-table-column
                    fixed="right"
                    label="操作"
                    width="360"
                >
                    <template>
                        <el-dropdown size="small" split-button type="primary" @click="dialogVisible = true">
                            编辑
                            <el-dropdown-menu slot="dropdown" @click="dialogVisible = true">
                                <el-dropdown-item @click="dialogVisible = true">
                                    信息变更
                                </el-dropdown-item>
                                <el-dropdown-item>
                                    修改权限
                                </el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                        &nbsp;
                        <el-button
                            type="primary"
                            size="small"
                            @click="dialogVisible = true"
                        >
                            详情
                        </el-button>
                        <el-button
                            type="danger"
                            size="small"
                            @click="dialogVisible = true"
                        >
                            移除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-dialog
                title="操作提示"
                :visible.sync="dialogVisible"
                width="30%"
            >
                <span>开发中 此操作暂时拒绝</span>
                <span slot="footer" class="dialog-footer">
                    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                    <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                </span>
            </el-dialog>
            <el-pagination
                :current-page="currentPage4"
                :page-sizes="[1, 3, 5, 10]"
                :page-size="10"
                layout="total, sizes, prev, pager, next, jumper"
                :total="40"
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
            />
        </el-card>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
export default {
    name: 'PersonalDic',
    components: {PageHeader},
    data() {
        return {
            dialogVisible: false,
            currentPage2: 5,
            currentPage3: 5,
            currentPage4: 4,
            tableData: [{
                name: 'Shellwe',
                notes: '测试数据',
                state: '正常'
            }, {
                name: 'Shellwe',
                notes: '响应操作',
                state: '停用'
            }, {
                name: 'Shellwe',
                notes: '不会改变',
                state: '弃用'
            }]
        }
    },
    mounted: function() {
        this.loadInformation()
    },
    methods: {
        back() {
            history.go(-1)
        },
        // 修改显示状态
        changeMask: function(b) {
            if (b) {
                document.getElementById('abc').style.cursor = 'pointer'
            } else {
                document.getElementById('abc').style.cursor = 'wait'
            }
            console.log(b)
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`)
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`)
        }
    }
}
</script>
