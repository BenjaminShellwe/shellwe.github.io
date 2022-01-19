<template>
    <div>
        <page-header title="数据脱敏">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为数据脱敏设置
                </div>
            </template>
        </page-header>
        <el-alert
            title="至少保留一个脱敏设置以保证数据在非可信渠道传输时启用"
            type="warning"
        />
        <page-main>
            <el-card>
                <el-row calss="pageCSSelrow">
                    <el-button-group>
                        <span>交由网页系统处理脱敏</span>
                        <el-select v-model="pageSelectValue" placeholder="默认中级" size="small" class="pageCSSSelect" shadow="hover">
                            <el-option
                                v-for="item in pageSelectOptions"
                                :key="item.pageSelectValue"
                                :label="item.pageSelectLabel"
                                :value="item.pageSelectValue"
                            />
                        </el-select>
                        <el-tooltip class="item" effect="dark" content="脱敏字符数 默认5" placement="top">
                            <el-input-number v-model="num" :min="1" :max="10" size="small" class="pageCSSSelect" />
                        </el-tooltip>
                    </el-button-group>
                    <el-button type="primary" size="small">提交</el-button>
                </el-row>
                <el-row class="pageCSSelrow">
                    <el-button-group>
                        <span>交由系统后台处理脱敏</span>
                        <el-select v-model="pageSelectValue" placeholder="默认中级" size="small" class="pageCSSSelect" shadow="hover">
                            <el-option
                                v-for="item in pageSelectOptions"
                                :key="item.pageSelectValue"
                                :label="item.pageSelectLabel"
                                :value="item.pageSelectValue"
                            />
                        </el-select>
                        <el-tooltip class="item" effect="dark" content="脱敏字符数 默认5" placement="top">
                            <el-input-number v-model="num" :min="1" :max="10" size="small" class="pageCSSSelect" />
                        </el-tooltip>
                    </el-button-group>
                    <el-button type="primary" size="small">提交</el-button>
                </el-row>
            </el-card>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Desensitize',
    components: {PageMain, PageHeader},
    data() {
        return {
            pageSelectOptions: [{
                pageSelectValue: 'psv1',
                pageSelectLabel: '次级'
            }, {
                value: 'psv2',
                pageSelectValue: '初级'
            }, {
                value: 'psv3',
                pageSelectValue: '中级'
            }, {
                value: 'psv4',
                pageSelectValue: '高级'
            }, {
                value: 'psv5',
                pageSelectValue: '特级'
            }],
            pageSelectValue: '',
            num: 5
        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageCSSSelect {
    width: 100px;
    margin-left: 5px;
    margin-right: 5px;
}
.pageCSSelrow {
    margin-top: 5px;
}
</style>
