
public class MemoryNode {
		protected MemoryNode leftChild;
		protected MemoryNode rightChild;
		protected int height;
		protected Action preferedAction;
		protected Double responseRate;
		protected Memory memory;
		protected Double intensity;
		

		public MemoryNode(Memory Memory) {
			this.memory = Memory;
			this.leftChild = null;
			this.rightChild = null;
			this.height = 0;
			this.preferedAction = new Action();
			this.responseRate = null;
			this.intensity = null;
		}
		
		public Memory getMem() {
			return this.memory;
		}

		public MemoryNode getLeftChild() {
			return this.leftChild;
		}

		public MemoryNode getRightChild() {
			return this.rightChild;
		}
		
		public Action getPreferedAction() {
			return preferedAction;
		}

		public void setPreferedAction(String action) {
			this.preferedAction.setAction(action);
		}

		public double getResponseRate() {
			return responseRate.doubleValue();
		}

		public void setResponseRate(Double responseRate) {
			this.responseRate = responseRate;
		}

		// figure out a way to compare memories
		
		public MemoryNode insert(MemoryNode memoryNode, Tree.MyBoolean b) {

			if (this.intensity > memoryNode.intensity) {
				if (leftChild != null) {
					leftChild = leftChild.insert(memoryNode, b);
				} else {
					leftChild = memoryNode;
				}
			}
			if (this.intensity < memoryNode.intensity) {
				if (rightChild != null) {
					rightChild = rightChild.insert(memoryNode, b);
				} else {
					rightChild = memoryNode;
				}
			}
			updateHeight();
			return checkBalance();
		}

		public MemoryNode remove(MemoryNode memory, Tree.MyBoolean b1) {
			if (this.equals(memory)) {
				if (this.leftChild == null & this.rightChild == null) {
					updateHeight();
					return null;
				}

				if (this.leftChild == null) {
					updateHeight();
					return this.rightChild;
				}

				if (this.rightChild == null) {
					updateHeight();
					return this.leftChild;
				}

				this.memory = this.leftChild.findMax();
				leftChild = leftChild.remove(this, b1);
				return checkBalance();
			} else if (this.intensity>memory.intensity) {
				if (leftChild != null) {
					this.leftChild = leftChild.remove(memory, b1);
				} else {
					b1.setFalse();
				}
			} else if (this.intensity<memory.intensity) {
				if (rightChild != null) {
					this.rightChild = rightChild.remove(memory, b1);
				} else {
					b1.setFalse();
				}
			}
			updateHeight();
			return checkBalance();
		}
				
		public MemoryNode checkBalance() {
			int leftHeight = -1;
			int rightHeight = -1;
			if (leftChild != null)
				leftHeight = leftChild.height;
			if (rightChild != null)
				rightHeight = rightChild.height;
			if ((leftHeight - rightHeight) > 1) {
				int rHeight = -1;
				if (this.leftChild.rightChild != null)
					rHeight = this.leftChild.rightChild.height;
				if (this.leftChild.leftChild != null && this.leftChild.leftChild.height >= rHeight) {
					return this.singleRightRotation();
				} else {
					return this.doubleRightRotation();
				}
			}
			if ((leftHeight - rightHeight) < -1) {
				int lHeight = -1;
				if (this.rightChild.leftChild != null)
					lHeight = this.rightChild.leftChild.height;
				if (this.rightChild.rightChild != null && this.rightChild.rightChild.height >= lHeight) {
					return this.singleLeftRotation();
				} else {
					return this.doubleLeftRotation();
				}
			}
			return this;
		}

		public void updateHeight() {
			int leftHeight = -1;
			int rightHeight = -1;
			if (rightChild != null)
				rightHeight = rightChild.height;
			if (leftChild != null)
				leftHeight = leftChild.height;
			height = Math.max(rightHeight, leftHeight) + 1;
		}

		public Memory findMax() {
			if (this.rightChild == null) {
				return this.memory;
			}
			return this.rightChild.findMax();

		}

		public MemoryNode singleLeftRotation() {
			MemoryNode node = this;
			MemoryNode rightNode = this.rightChild;
			MemoryNode rightLeftNode = rightNode.leftChild;
			rightNode.leftChild = node;
			node.rightChild = rightLeftNode;
			updateHeight();
			return rightNode;
		}

		public MemoryNode doubleLeftRotation() {
			rightChild = rightChild.singleRightRotation();
			rightChild.updateHeight();
			updateHeight();
			return this.singleLeftRotation();
		}

		public MemoryNode singleRightRotation() {
			MemoryNode node = this;
			MemoryNode leftNode = this.leftChild;
			MemoryNode leftRightNode = leftNode.rightChild;
			leftNode.rightChild = node;
			node.leftChild = leftRightNode;
			updateHeight();
			return leftNode;
		}

		public MemoryNode doubleRightRotation() {
			leftChild = leftChild.singleLeftRotation();
			leftChild.updateHeight();
			updateHeight();
			return this.singleRightRotation();
		}
	
}