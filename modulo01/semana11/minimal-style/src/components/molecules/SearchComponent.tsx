
import { useState } from 'react';
import {Button} from '../atoms/Button';

interface SearchProps {
  onSearch: (query: string) => void;
}

export function SearchComponent({ onSearch }: SearchProps): JSX.Element {
  const [isSearching, setIsSearching] = useState<boolean>(false);
  const [searchQuery, setSearchQuery] = useState<string>('');

  const handleSearchIconClick = () => {
    setIsSearching(true);
  };

  const handleSearch = () => {
    onSearch(searchQuery);
    setIsSearching(false);
  };

  return (
    <div>
      {!isSearching ? (
        <span
          role="img"
          aria-label="search"
          onClick={handleSearchIconClick}
          style={{ cursor: 'pointer' }}
        >
          🔍
        </span>
      ) : (
        <div>
          <input
            type="text"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            placeholder="Digite sua pesquisa"
          />
          <Button onClick={handleSearch}>Pesquisar</Button>
        </div>
      )}
    </div>
  );
}
