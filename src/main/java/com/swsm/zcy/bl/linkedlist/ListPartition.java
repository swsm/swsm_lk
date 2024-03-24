package com.swsm.zcy.bl.linkedlist;

/**
 * @author liujie
 * @date 2023-06-15
 */
public class ListPartition {


    /**
     * 给定一个链表，在给定一个锚点，将链表修改为左边都是小于锚点中间是等于锚点右边是大于锚点
     * 逻辑：
     * 1. 先准备小于头节点(sH)小于尾节点(sT),等于头节点(eH)等于尾节点(eT),大于头节点(mH)大于尾节点(mT)
     * 2. 当前节点不为空，当前节点的下一节点保留为next，当前节点指向下一节点断掉
     * 3. 判断当前节点的值小于锚点，如果sH为空则设置sH和sT都是当前节点 否则sT的下一节点指向当前节点，sT指向当前节点
     * 4. 判断当前节点的值等于锚点，如果eH为空则设置eH和eT都是当前节点 否则eT的下一节点指向当前节点，eT指向当前节点
     * 5. 判断当前节点的值大于锚点，如果mH为空则设置mH和mT都是当前节点 否则mT的下一节点指向当前节点，mT指向当前节点
     * 6. 当前节点为当前节点下一节点，循环2操作
     * 7. 上面全部处理完后，有3个链表(小于 等于 大于)出现，
     * 8. 将三个链表尾头相连(注意3个链表中可能会有某个链表头为空)，组成一个链表，再返回头节点
     */
    public static Node listPartition(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
    
    
    
}
