package hunk;

import java.io.IOException;

import ghidra.app.util.bin.BinaryReader;

public class HunkNameBlock extends HunkBlock {
	
	private String name;
	
	HunkNameBlock(BinaryReader reader, boolean isExecutable) throws HunkParseError {
		super(HunkType.HUNK_NAME, reader);

		parse(reader, isExecutable);
		calcHunkSize(reader);
	}

	@Override
	void parse(BinaryReader reader, boolean isExecutable) throws HunkParseError {
		try {
			name = HunkBlock.readName(reader);
		} catch (IOException e) {
			throw new HunkParseError(e);
		}
	}

	public String getName() {
		return name;
	}
}
