const Mock = require('mockjs')

export default {
    'POST /mock/member/login': (req, res) => {
        return res.json(Mock.mock({
            error: '',
            status: 1,
            data: {
                account: req.body.account,
                token: '@string',
                failure_time: Date.parse(new Date()) / 1000 + 24 * 60 * 60
            }
        }))
    },
    'GET /mock/member/permission': (req, res) => {
        let permissions = []
        if (req.query.account == 'admin') {
            permissions = [
                'permission.browse',
                'permission.basic',
                'permission.create',
                'permission.edit',
                'permission.remove',
                'permission.access',
                'permission.department'
            ]
        } else if (req.query.account == 'test') {
            permissions = [
                'permission.basic',
                'permission.access'
            ]
        } else if (req.query.account == 'visitor') {
            permissions = [
                'permission.basic'
            ]
        }
        return res.json({
            error: '',
            status: 1,
            data: {
                permissions
            }
        })
    }
}
