<template>
    <div>
        <page-header title="全局字典">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    <div style="margin-bottom: 5px;">此页面为全局字典设置,在此页面控制本账号全局字典使用方式</div>
                    <span>是否开启数据字典 </span>
                    <el-switch
                        v-model="isShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click="changeShow"
                    />
                </div>
            </template>
        </page-header>
        <page-main v-show="isShow" id="collapsible">
            <span style="line-height: 2.2;">是否允许系统读取个人字典
                <el-switch
                    v-model="value1"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    active-text="允许"
                    inactive-text="拒绝"
                />
            </span><br>

            <div class="inLine">
                <span slot="label">
                    <el-tooltip content="定义字典的名称 必填" placement="top">
                        <i class="el-icon-warning-outline" style="color: red;" />
                    </el-tooltip>
                </span>
                模板名称&nbsp;
                <div class="inLine">
                    <el-input
                        v-model="input1"
                        type="text"
                        size="small"
                        placeholder="请输入模板名称"
                        style="display: inline;"
                        maxlength="10"
                        show-word-limit
                    />
                </div>
            </div>
            &nbsp;&nbsp;
            <div class="inLine">
                <span slot="label">
                    <el-tooltip content="提供模板数据说明" placement="top">
                        <i class="el-icon-question" />
                    </el-tooltip>
                </span>
                模板说明&nbsp;
                <div class="inLine">
                    <el-input
                        v-model="input2"
                        type="text"
                        size="small"
                        placeholder="请输入模板说明"
                        style="display: inline;"
                        clearable
                    />
                </div>
            </div>
            &nbsp;&nbsp;
            <el-button type="primary" icon="el-icon-search" @click="dialogVisible = true">搜索</el-button>
            &nbsp;&nbsp;&nbsp;
            <el-tooltip content="创建新字典数据" placement="top">
                <el-button type="primary" icon="el-icon-document-add" @click="dialogVisible = true">创建</el-button>
            </el-tooltip>
            <br>
            <div>
                <span slot="label">
                    <el-tooltip content="定义字典的状态 必选 审核为工作人员使用" placement="top">
                        <i class="el-icon-warning-outline" style="color: red;" />
                    </el-tooltip>
                </span>
                模板状态&nbsp;
                <el-select v-model="valueState" placeholder="请选择">
                    <el-option
                        v-for="item in options"
                        :key="item.valueState"
                        :label="item.label"
                        :value="item.valueState"
                        :disabled="item.disabled"
                    />
                </el-select>
            </div>
        </page-main>
        <page-main>
            <template>
                <el-table :key="key" v-loading="false" :data="data" style="width: 100%;">
                    <el-table-column v-for="items in formThead"
                                     :key="items.prop"
                                     :label="items.label"
                                     :width="items.width"
                                     show-overflow-tooltip
                    >
                        <template slot-scope="scope">
                            {{ scope.row[items.prop] }}
                        </template>
                    </el-table-column>
                    <el-table-column
                        fixed="right"
                        label="操作"
                        width="290"
                    >
                        <template slot-scope="scope">
                            <el-button type="primary" size="small" @click="handleClick(scope.row)">查看</el-button>
                            <el-button type="primary" size="small" @click="dialogVisible = true">编辑</el-button>
                            <el-button type="danger" size="small" @click.native.prevent="dialogVisible = true">移除</el-button>
                            <!--                            <el-button type="danger" size="small" @click.native.prevent="deleteRow(scope.$index, data)">移除</el-button>-->
                        </template>
                    </el-table-column>
                </el-table>
            </template>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>开发中 此操作暂时拒绝</span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
const fields = [
    {label: '日期', prop: 'date'},
    {label: '模板名称', prop: 'model_name'},
    {label: '模板说明', prop: 'model_explain'},
    {label: '模板状态', prop: 'model_state'}
]
export default {
    name: 'GlobalDic',
    components: {PageMain},
    data() {
        return {
            dialogVisible: false,
            isShow: true,
            value1: true,
            input1: '',
            input2: '',
            valueState: '',
            options: [{
                valueState: 'options1',
                label: '有效'
            }, {
                valueState: 'options2',
                label: '无效'
            }, {
                valueState: 'options3',
                label: '审核',
                disabled: true
            }],
            key: 1, // table key
            formThead: fields, // 默认表头 Default header
            data: [{
                date: '2022-01-12-17:57',
                model_name: '示例1',
                model_explain: '展示示例',
                model_state: '有效'
            }]
        }
    },
    watch: {
        /**
         * 监控表格的数据data，自动设置表格宽度
         * @param https://www.cnblogs.com/huangxiaoxue/p/12034326.html
         */
        data(valArr) {
            const _this = this
            this.formThead = fields.map(function(value) {
                const arr = valArr.map(x => x[value.prop])  // 获取每一列的所有数据
                arr.push(value.label)  // 把每列的表头也加进去算
                value.width = _this.getMaxLength(arr) + 20 // 每列内容最大的宽度 + 表格的内间距(依据实际情况而定)
                return value
            })
        }
    },
    methods: {
        changeShow: function() {
            this.isShow = !this.isShow
            if (this.isShow == false) {
                this.value1 = false
            }
        },
        back() {
            history.go(-1)
        },
        handleClick(row) {
            console.log(row)
        },
        getMaxLength(arr) {
            return arr.reduce((acc, item) => {
                if (item) {
                    let calcLen = this.getTextWidth(item)
                    if (acc < calcLen) {
                        acc = calcLen
                    }
                }
                return acc
            }, 0)
        },
        getTextWidth(str) {
            let width = 0
            let html = document.createElement('span')
            html.innerText = str
            html.className = 'getTextWidth'
            document.querySelector('body').appendChild(html)
            width = document.querySelector('.getTextWidth').offsetWidth
            document.querySelector('.getTextWidth').remove()
            return width
        },
        deleteRow(index, rows) {
            rows.splice(index, 1)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.inLine {
    display: inline-block;
}
</style>
