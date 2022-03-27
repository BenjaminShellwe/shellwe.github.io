package top.shellwe.bip.system.dto.output;

import com.google.common.collect.Lists;
import lombok.Data;
import top.shellwe.bip.system.entity.User;

import java.util.List;

/**
 *  <p> 用户树节点 </p>
 */
@Data
public class UserTreeNode extends User {

    List<UserTreeNode> children = Lists.newArrayList();

}
