public class Tree{
	MemoryNode root;
	int size;
	int modCount = 0;
	int rotationCount = 0;
	int doubleRotationCount = 0;

	public Tree() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	public int height() {
		if (root == null)
			return -1;
		return root.height;
	}

	public boolean insert(MemoryNode memory) {
		MyBoolean b = new MyBoolean();
		if (memory == null) {
			throw new IllegalArgumentException();
		}
		if (root == null) {
			root = memory;
			size++;
			modCount++;
			return b.getValue();
		}
		root = root.insert(memory, b);
		if (b.getValue()) {
			size++;
			modCount++;
		}
		return b.getValue();
	}

	public boolean remove(MemoryNode memory) {
		if (memory == null) {
			throw new IllegalArgumentException();
		}
		if (root == null) {
			return false;
		}
		MyBoolean b1 = new MyBoolean();
		root = root.remove(memory, b1);
		if (b1.getValue()) {
			size--;
			modCount++;
		}
		return b1.getValue();
	}

	public int size() {
		return size;
	}
	
	class MyBoolean {
		private boolean value = true;

		public boolean getValue() {
			return value;
		}

		public void setFalse() {
			value = false;
		}
	}

	
}
