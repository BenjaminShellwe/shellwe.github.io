package top.shellwe.bip.system.dto.output;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.google.common.collect.Lists;
import top.shellwe.bip.system.entity.SystemUrl;
import lombok.Data;

import java.util.List;

/**
 *  <p> 菜单树节点 </p>
 *
 */
@Data
public class SystemUrlTreeNode extends SystemUrl {

    List<SystemUrlTreeNode> children = Lists.newArrayList();

}
